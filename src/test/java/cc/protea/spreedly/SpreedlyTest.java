package cc.protea.spreedly;

import java.util.List;

import cc.protea.spreedly.model.SpreedlyGatewayAccount;
import cc.protea.spreedly.model.SpreedlyGatewayAccountState;
import cc.protea.spreedly.model.SpreedlyGatewayCredential;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import cc.protea.spreedly.model.SpreedlyGatewayProvider;


public class SpreedlyTest {

	Spreedly spreedly;
	SpreedlyGatewayAccount testAccount;

	@Before
	public void before() {
		spreedly = SpreedlyTest.getSpreedly();
	}

    @Test
    public void testGetGatewayProviders() throws Exception {
    	if (spreedly == null) {
    		return;
    	}
    	final List<SpreedlyGatewayProvider> list = spreedly.listGatewayProviders();
    	Assert.assertNotNull(list);
    	Assert.assertTrue(! list.isEmpty());
    }

	@Test
	public void testCreate() throws Exception {
		if (spreedly == null) {
			return;
		}
		SpreedlyGatewayAccount account = new SpreedlyGatewayAccount();
		account.gatewayType = "sage";
		SpreedlyGatewayCredential c = new SpreedlyGatewayCredential();
		c.name = "merchant_id_number";
		c.value = "12345";
		account.credentials.add(c);

		final SpreedlyGatewayAccount createdAccount = spreedly.create(account);
		Assert.assertNotNull(createdAccount);
		Assert.assertTrue(createdAccount.getToken() == "sage");
		Assert.assertTrue(createdAccount.getGatewayType() == "sage");
		Assert.assertTrue(!createdAccount.getCredentials().isEmpty());
		Assert.assertTrue(createdAccount.getCredentials().get(0).getName() == "merchant_id_number");
		Assert.assertTrue(createdAccount.getCredentials().get(0).getValue() == "12345");

		testAccount = createdAccount;
	}

	@Test
	public void testRedact() throws Exception {
		if (spreedly == null) {
			return;
		}

		SpreedlyGatewayAccount redactedAccount = spreedly.redact(testAccount);
		Assert.assertTrue(redactedAccount.getState() == SpreedlyGatewayAccountState.REDACTED);
	}

	@Test
	public void testRetain() throws Exception {
		if (spreedly == null) {
			return;
		}
		SpreedlyGatewayAccount retainedAccount = spreedly.retain(testAccount);
		Assert.assertTrue(retainedAccount.getState() == SpreedlyGatewayAccountState.RETAINED);
	}

	@Test
	public void testGetGatewayAccounts() throws Exception {
		if (spreedly == null) {
			return;
		}
		final List<SpreedlyGatewayAccount> list = spreedly.listGatewayAccounts();
		Assert.assertNotNull(list);
		Assert.assertTrue(! list.isEmpty());
	}

    public static Spreedly getSpreedly() {
		final String environmentKey = SpreedlyTest.getEnvironmentKey();
		final String apiSecret = SpreedlyTest.getApiSecret();
		if (environmentKey == null || apiSecret == null) {
			return null;
		}
		return new Spreedly(environmentKey, apiSecret);
    }

	private static String getEnvironmentKey() {
		return System.getenv("SPREEDLYCORE_ENVIRONMENT_KEY");
	}

	private static String getApiSecret() {
		return System.getenv("SPREEDLYCORE_API_SECRET");
	}

}
