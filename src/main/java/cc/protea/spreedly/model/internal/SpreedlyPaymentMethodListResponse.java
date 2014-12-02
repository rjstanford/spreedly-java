package cc.protea.spreedly.model.internal;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import cc.protea.spreedly.model.SpreedlyPaymentMethod;

@XmlRootElement(name = "payment_methods")
public class SpreedlyPaymentMethodListResponse {

	@XmlElement(name = "payment_method")
	public List<SpreedlyPaymentMethod> paymentMethods = new ArrayList<SpreedlyPaymentMethod>();

}