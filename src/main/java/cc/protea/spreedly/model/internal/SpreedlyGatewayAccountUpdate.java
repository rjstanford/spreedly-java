package cc.protea.spreedly.model.internal;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import cc.protea.spreedly.model.SpreedlyGatewayAccount;
import cc.protea.spreedly.model.SpreedlyGatewayCredential;

@XmlRootElement(name = "gateway")
public class SpreedlyGatewayAccountUpdate {

	public SpreedlyGatewayAccountUpdate(final SpreedlyGatewayAccount in) {
		this.gatewayType = in.gatewayType;
		this.credentials.addAll(in.credentials);
	}

	@XmlElement(name = "gateway_type")
	public String gatewayType;

	@XmlElementWrapper(name = "credentials")
	@XmlElement(name = "credential")
	public List<SpreedlyGatewayCredential> credentials = new ArrayList<SpreedlyGatewayCredential>();

}
