package cc.protea.spreedly.model.internal;

import cc.protea.spreedly.model.SpreedlyGatewayAccount;
import cc.protea.spreedly.model.SpreedlyGatewayCredential;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.StringWriter;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

public class SpreedlyGatewayAccountUpdateTest {

	JAXBContext context;
	Marshaller marshaller;
	Unmarshaller unmarshaller;
	String xml;

	@Before
	public void before() throws JAXBException, URISyntaxException, FileNotFoundException {

		context = JAXBContext.newInstance(SpreedlyGatewayAccountUpdate.class);
		marshaller = context.createMarshaller();
		unmarshaller = context.createUnmarshaller();

		URL url = getClass().getResource("/SpreedlyGatewayAccountUpdate.xml");
		xml = new Scanner(new File(url.toURI())).useDelimiter("\\Z").next();
	}

	@Test
	public void test() throws JAXBException {

		SpreedlyGatewayAccount account = new SpreedlyGatewayAccount();
		account.gatewayType = "sage";
		SpreedlyGatewayCredential c = new SpreedlyGatewayCredential();
		c.name = "merchant_id_number";
		c.value = "12345";
		account.credentials.add(c);
		c = new SpreedlyGatewayCredential();
		c.name = "merchant_key_number";
		c.value = "24601";
		account.credentials.add(c);

		SpreedlyGatewayAccountUpdate obj = new SpreedlyGatewayAccountUpdate(account);
		String response = get(obj);
		Assert.assertNotNull(response);
		Assert.assertEquals(xml, response);
	}

	String get(SpreedlyGatewayAccountUpdate object) throws JAXBException {
		StringWriter writer = new StringWriter();
		marshaller.marshal(object, writer);
		return writer.toString();
	}
}
