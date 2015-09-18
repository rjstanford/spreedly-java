package cc.protea.spreedly.model.internal;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import cc.protea.spreedly.model.SpreedlyCreditCard;

@XmlRootElement(name = "payment_method")
public class SpreedlyPaymentMethodCreateRequest {

	@XmlElement(name = "credit_card") public SpreedlyCreditCard creditCard;
	@XmlElement(name = "email") public String email;
	@XmlElement(name = "data") public Object data;
}
