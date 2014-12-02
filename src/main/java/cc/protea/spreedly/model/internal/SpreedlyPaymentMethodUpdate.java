package cc.protea.spreedly.model.internal;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "gateway")
public class SpreedlyPaymentMethodUpdate {

	@XmlElement(name = "remove_from_gateway") public String gatewayAccountToken;
}
