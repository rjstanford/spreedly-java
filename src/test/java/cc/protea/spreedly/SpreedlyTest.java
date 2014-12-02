package cc.protea.spreedly;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import cc.protea.spreedly.model.SpreedlyGatewayProvider;


public class SpreedlyTest {

	Spreedly spreedly;

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
