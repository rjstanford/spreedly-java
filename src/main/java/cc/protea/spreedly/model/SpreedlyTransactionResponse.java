package cc.protea.spreedly.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import cc.protea.spreedly.model.internal.SpreedlyRandomMapAdapter;

@XmlRootElement(name = "transaction")
public class SpreedlyTransactionResponse {

	@XmlElement(name = "amount") public Integer amountInCents;
	@XmlElement(name = "on_test_gateway") public boolean onTestGateway;
	@XmlElement(name = "created_at") public Date createdOn;
	@XmlElement(name = "updated_at") public Date updatedOn;
	@XmlElement(name = "currency_code") public String currencyCode;
	public boolean succeeded;
	public SpreedlyTransactionState state;
	public String token;
	@XmlElement(name = "transaction_type") public SpreedlyTransactionType transactionType;
	@XmlElement(name = "order_id") public String orderId;
	@XmlElement(name = "ip") public String clientIpAddress;
	public String description;
	public String email;
	@XmlElement(name = "merchant_name_descriptor") public String merchantNameDescriptor;
	@XmlElement(name = "merchant_location_descriptor") public String merchantLocationDescriptor;
	@XmlJavaTypeAdapter(SpreedlyRandomMapAdapter.class)
	@XmlElement(name = "gateway_specific_fields") public Map<String, String> gatewaySpecificFields = new HashMap<String, String>();
	@XmlJavaTypeAdapter(SpreedlyRandomMapAdapter.class)
	@XmlElement(name = "gateway_specific_response_fields") public Map<String, String> gatewaySpecificResponseFields = new HashMap<String, String>();
	@XmlElement(name = "gateway_transaction_id") public String gatewayTransactionId;
	@XmlElement(name = "retain_on_success") public boolean retainOnSuccess;
	@XmlElement(name = "payment_method_added") public boolean paymentMethodAdded;
	public SpreedlyMessage message;
	@XmlElement(name = "gateway_token") public String gatewayToken;
	public SpreedlyTransactionResponseResponse response;
	@XmlElement(name = "payment_method") public SpreedlyPaymentMethod paymentMethod;
	@XmlElement(name = "basis_payment_method") public SpreedlyPaymentMethod basisPaymentMethod;
	@XmlElement(name = "api_urls") public SpreedlyApiURLs apiUrls;
	@XmlElement(name = "callback_url") public String callbackUrl;
	@XmlElement(name = "redirect_url") public String redirectUrl;
	@XmlElement(name = "checkout_url") public String checkoutUrl;
	@XmlElement(name = "checkout_form") public String checkoutForm;
	@XmlElement(name = "setup_response") public SpreedlySetupResponse setupResponse;
}