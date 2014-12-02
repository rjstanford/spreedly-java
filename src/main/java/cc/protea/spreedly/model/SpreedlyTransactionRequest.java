package cc.protea.spreedly.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name = "transaction")
public class SpreedlyTransactionRequest {
	@XmlTransient public String gatewayAccountToken;
	@XmlTransient public String referenceTransactionToken;
	@XmlElement(name = "amount") public Integer amountInCents;
	@XmlElement(name = "currency_code") public String currencyCode;
	@XmlElement(name = "payment_method_token") public String paymentMethodToken;
	@XmlElement(name = "retain_on_success") public boolean retainOnSuccess;
	@XmlElement(name = "order_id") public String orderId;
	public String description;
	@XmlElement(name = "ip") public String clientIpAddress;
	public String email;
	@XmlElement(name = "merchant_name_descriptor") public String merchantNameDescriptor;
	@XmlElement(name = "merchant_location_descriptor") public String merchantLocationDescriptor;
}