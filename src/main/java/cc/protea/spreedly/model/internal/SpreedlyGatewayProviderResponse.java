package cc.protea.spreedly.model.internal;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import cc.protea.spreedly.model.SpreedlyGatewayProvider;

@XmlRootElement(name = "gateways")
public class SpreedlyGatewayProviderResponse {

	@XmlElement(name = "gateway")
	public List<SpreedlyGatewayProvider> gateways = new ArrayList<SpreedlyGatewayProvider>();

}