package cc.protea.spreedly;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringWriter;

import javax.xml.bind.DatatypeConverter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import cc.protea.util.http.Request;
import cc.protea.util.http.Response;

public class SpreedlyUtil {

	private final String enironmentKey;
	private final String apiSecret;

	public SpreedlyUtil(final String environmentKey, final String apiSecret) {
		this.enironmentKey = environmentKey;
		this.apiSecret = apiSecret;
	}

	<T> T options(final String url, final Class<T> type) {
		try {
			Response response = getService(url).optionsResource();
			return convert(response.getBody(), type);
		} catch (IOException e) {
			throw new SpreedlyException(e);
		}
	}

	<T> T get(final String url, final Class<T> type) {
		try {
			Response response = getService(url).getResource();
			return convert(response.getBody(), type);
		} catch (IOException e) {
			throw new SpreedlyException(e);
		}
	}

	<T> T delete(final String url, final Object bodyObject, final Class<T> type) {
		try {
			String body = convert(bodyObject);
			Response response = getService(url).setBody(body).deleteResource();
			return convert(response.getBody(), type);
		} catch (IOException e) {
			throw new SpreedlyException(e);
		}
	}

	void delete(final String url, final Object bodyObject) {
		try {
			String body = convert(bodyObject);
			getService(url).setBody(body).deleteResource();
		} catch (IOException e) {
			throw new SpreedlyException(e);
		}
	}

	<T> T put(final String url, final Object bodyObject, final Class<T> type) {
		try {
			String body = convert(bodyObject);
			Response response = getService(url).setBody(body).putResource();
			return convert(response.getBody(), type);
		} catch (IOException e) {
			throw new SpreedlyException(e);
		}
	}

	<T> T post(final String url, final Object bodyObject, final Class<T> type) {
		try {
			String body = convert(bodyObject);
			Response response = getService(url).setBody(body).postResource();
			return convert(response.getBody(), type);
		} catch (IOException e) {
			throw new SpreedlyException(e);
		}
	}

	private String getAuthorizationHeader() {
		final String pair = this.enironmentKey + ":" + this.apiSecret;
		final String base64 = DatatypeConverter.printBase64Binary(pair.getBytes());
		return "Basic " + base64;
	}

	private Request getService(final String url) {
		return new Request(url)
			.addHeader("Authorization", getAuthorizationHeader())
			.addHeader("Accept", "application/xml");
	}

	@SuppressWarnings("unchecked")
	private <T> T convert(final String xml, final Class<T> type) {
        if (String.class.equals(type)) {
        	return (T) xml;
        }
		try {
			JAXBContext context = JAXBContext.newInstance(type);
	        Unmarshaller un = context.createUnmarshaller();
	        ByteArrayInputStream is = new ByteArrayInputStream(xml.getBytes());
	        return (T) un.unmarshal(is);
		} catch (JAXBException e) {
			throw new SpreedlyException(e);
		}
	}

	private String convert(final Object object) {
		try {
			if (object == null) {
				return "";
			}
			JAXBContext context = JAXBContext.newInstance(object.getClass());
			Marshaller marshaller = context.createMarshaller();
			StringWriter writer = new StringWriter();
			marshaller.marshal(object, writer);
			return writer.toString();
		} catch (JAXBException e) {
			throw new SpreedlyException(e);
		}

	}

}
