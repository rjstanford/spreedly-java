package cc.protea.spreedly;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import cc.protea.spreedly.model.internal.SpreedlyErrors;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import cc.protea.spreedly.model.SpreedlyTransactionResponse;
import cc.protea.spreedly.model.internal.SpreedlyNestedMapAdapter;

// Example taken from https://docs.spreedly.com/payment-gateways/paypal/
//
// This tests most of the stranger XML parsing.

public class SpreedlyErrorHandlingTest {

	SpreedlyNestedMapAdapter adapter;
	JAXBContext context;
    Unmarshaller unmarshaller;
    String xml;
    SpreedlyUtil spreedlyUtil;

	@Before
	public void before() throws URISyntaxException, FileNotFoundException {
		spreedlyUtil = new SpreedlyUtil(null, null);
		URL url = getClass().getResource("/SpreedlyTransactionResponseError.xml");
		File file = new File(url.toURI());
		xml = new Scanner(file).useDelimiter("\\Z").next();
	}

	@Test
	public void testUnderlying() {
		SpreedlyErrors errors = spreedlyUtil.convert(xml, SpreedlyErrors.class, false);
		Assert.assertNotNull(errors);
		Assert.assertNotNull(errors.errors);
		Assert.assertEquals(2, errors.errors.size());
		Assert.assertEquals(errors.errors.get(0).error, "Merchant id number can't be blank");
		Assert.assertEquals(errors.errors.get(0).key, "errors.blank");
		Assert.assertEquals(errors.errors.get(0).attribute, "merchant_id_number");
	}

	@Test
	public void test() {
		try {
			spreedlyUtil.convert(xml, SpreedlyTransactionResponse.class);
		} catch (SpreedlyException e) {
			Assert.assertEquals("errors.blank", e.errorCode);
			Assert.assertEquals("Merchant id number can't be blank", e.errorMessage);
		}
	}

	@Test
	public void testAddError() {
		try {
			spreedlyUtil.convert(xml, SpreedlyTransactionResponse.class);
		} catch (SpreedlyException e) {
			SpreedlyTransactionResponse response = spreedlyUtil.addError(SpreedlyTransactionResponse.class, e);
			Assert.assertNotNull(response);
			Assert.assertEquals(false, response.succeeded);
			Assert.assertNotNull(response.message);
			Assert.assertEquals("Merchant id number can't be blank", response.message.message);
			Assert.assertEquals("errors.blank", response.message.key);
		}
	}
}
