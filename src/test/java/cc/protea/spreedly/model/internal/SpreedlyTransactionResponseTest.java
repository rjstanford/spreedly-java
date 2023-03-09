package cc.protea.spreedly.model.internal;

import java.io.File;
import java.io.StringWriter;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import cc.protea.spreedly.model.SpreedlyBorgunSpecificFields;
import cc.protea.spreedly.model.SpreedlyGatewaySpecificFields;
import cc.protea.spreedly.model.SpreedlyTransactionRequest;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import cc.protea.spreedly.model.SpreedlyTransactionResponse;

// Example taken from https://docs.spreedly.com/payment-gateways/paypal/
//
// This tests most of the stranger XML parsing.

public class SpreedlyTransactionResponseTest {

	SpreedlyNestedMapAdapter adapter;
	JAXBContext context;
    Unmarshaller unmarshaller;
    File xml;

	@Before
	public void before() throws JAXBException, URISyntaxException {
		context = JAXBContext.newInstance(SpreedlyTransactionResponse.class);
		unmarshaller = context.createUnmarshaller();
		adapter = new SpreedlyNestedMapAdapter();
		URL url = getClass().getResource("/SpreedlyTransactionResponse.xml");
		xml = new File(url.toURI());
	}

	@Test
	public void test() throws JAXBException {
		SpreedlyTransactionResponse response = (SpreedlyTransactionResponse) unmarshaller.unmarshal(xml);
		Assert.assertNotNull(response);
		Assert.assertEquals("1vcqQrU0d9f4NB5vdnx5wsoaAss", response.token);
		Assert.assertNotNull(response.gatewaySpecificResponseFields);
		Assert.assertFalse(response.gatewaySpecificResponseFields.isEmpty());
		Assert.assertEquals("wax@example.com", response.gatewaySpecificResponseFields.get("payer"));
		Assert.assertEquals("messages.transaction_succeeded", response.message.key);
		Assert.assertEquals("Succeeded!", response.message.message);
	}

}
