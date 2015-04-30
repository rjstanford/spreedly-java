package cc.protea.spreedly;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringWriter;

import javax.xml.bind.DatatypeConverter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

import cc.protea.spreedly.model.internal.SpreedlyErrorSetting;
import cc.protea.util.http.Request;
import cc.protea.util.http.Response;

class SpreedlyUtil {

	private final String environmentKey;
	private final String apiSecret;

	public SpreedlyUtil(final String environmentKey, final String apiSecret) {
		this.environmentKey = environmentKey;
		this.apiSecret = apiSecret;
	}

	<T> T options(final String url, final Class<T> type) {
		Response response = null;
		try {
			response = getService(url).optionsResource();
			return convert(response.getBody(), type);
		} catch (SpreedlyException e) {
			return addError(type, e);
		} catch (IOException e) {
			throw new SpreedlyException(e, response);
		}
	}

	<T> T get(final String url, final Class<T> type) {
		Response response = null;
		try {
			response = getService(url).getResource();
			return convert(response.getBody(), type);
		} catch (SpreedlyException e) {
			return addError(type, e);
		} catch (IOException e) {
			throw new SpreedlyException(e, response);
		}
	}

	<T> T delete(final String url, final Object bodyObject, final Class<T> type) {
		Response response = null;
		try {
			String body = convert(bodyObject);
			response = getService(url).setBody(body).deleteResource();
			return convert(response.getBody(), type);
		} catch (SpreedlyException e) {
			return addError(type, e);
		} catch (IOException e) {
			throw new SpreedlyException(e, response);
		}
	}

	void delete(final String url, final Object bodyObject) {
		Response response = null;
		try {
			String body = convert(bodyObject);
			response = getService(url).setBody(body).deleteResource();
		} catch (IOException e) {
			throw new SpreedlyException(e, response);
		}
	}

	<T> T put(final String url, final Object bodyObject, final Class<T> type) {
		Response response = null;
		try {
			String body = convert(bodyObject);
			response = getService(url).setBody(body).putResource();
			return convert(response.getBody(), type);
		} catch (SpreedlyException e) {
			return addError(type, e);
		} catch (IOException e) {
			throw new SpreedlyException(e, response);
		}
	}

	<T> T post(final String url, final Object bodyObject, final Class<T> type) {
		Response response = null;
		try {
			String body = convert(bodyObject);
			response = getService(url).setBody(body).postResource();
			return convert(response.getBody(), type);
		} catch (SpreedlyException e) {
			return addError(type, e);
		} catch (IOException e) {
			throw new SpreedlyException(e, response);
		}
	}

	private String getAuthorizationHeader() {
		final String pair = this.environmentKey + ":" + this.apiSecret;
		final String base64 = DatatypeConverter.printBase64Binary(pair.getBytes());
		return "Basic " + base64;
	}

	private Request getService(final String url) {
		return new Request(url)
			.addHeader("Authorization", getAuthorizationHeader())
			.addHeader("Accept", "application/xml")
			.addHeader("Content-Type", "application/xml");
	}

	private <T> T convert(final String xml, final Class<T> type) {
		return convert(xml, type, true);
	}

	@SuppressWarnings("unchecked")
	private <T> T convert(final String xml, final Class<T> type, final boolean handleErrors) {
		if (xml == null) {
			return null;
		}
        if (String.class.equals(type)) {
        	return (T) xml;
        }
		try {
			JAXBContext context = JAXBContext.newInstance(type);
	        Unmarshaller un = context.createUnmarshaller();
	        ByteArrayInputStream is = new ByteArrayInputStream(xml.getBytes());
	        return (T) un.unmarshal(is);
		} catch (JAXBException e) {
			if (! handleErrors) {
				throw new SpreedlyException(e);
			}
			if (xml.contains("<errors>")) {
				SpreedlyErrors errors = convert(xml, SpreedlyErrors.class, false);
				throw new SpreedlyException(e, errors.error.key, errors.error.error);
			}
			if (xml.contains("<hash>")) {
				SpreedlyHash hash = convert(xml, SpreedlyHash.class, false);
				throw new SpreedlyException(e, hash.status, hash.error);
			}
			throw new SpreedlyException(e);
		}
	}

	@XmlRootElement(name = "hash")
	private static class SpreedlyHash {
		public String status;
		public String error;
	}

	@XmlRootElement(name = "errors")
	private static class SpreedlyErrors {
		SpreedlyError error;
	}

	private static class SpreedlyError {
		@XmlValue public String error;
		@XmlAttribute(name = "key") public String key;
	}

	private <T> T addError(final Class<T> type, final SpreedlyException in) {
		try {
			return addError(type.newInstance(), in);
		} catch (SpreedlyException se) {
			throw se;
		} catch (Exception e) {
			throw new SpreedlyException(e);
		}
	}

	private <T> T addError(final T in, final SpreedlyException e) {
		if (in instanceof SpreedlyErrorSetting) {
			SpreedlyErrorSetting ses = (SpreedlyErrorSetting) in;
			ses.setError(e.errorCode, e.errorMessage);
		}
		return in;
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
