package cc.protea.spreedly.model.internal;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import cc.protea.spreedly.model.SpreedlyGatewayAccount;

@XmlRootElement(name = "gateways")
public class SpreedlyGatewayAccountResponse {

	@XmlElement(name = "gateway")
	public List<SpreedlyGatewayAccount> gateways = new ArrayList<SpreedlyGatewayAccount>();

}