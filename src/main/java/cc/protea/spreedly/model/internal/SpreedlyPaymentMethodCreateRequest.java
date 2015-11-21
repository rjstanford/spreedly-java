package cc.protea.spreedly.model.internal;

import javax.xml.bind.annotation.XmlElement;

import cc.protea.spreedly.model.SpreedlyCreditCard;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "payment_method")
public class SpreedlyPaymentMethodCreateRequest {

	@XmlElement(name = "credit_card") public SpreedlyCreditCard creditCard;
	@XmlElement(name = "email") public String email;
	@XmlElement(name = "data") public Object data;
}
