package cc.protea.spreedly.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

class SpreedlyGatewayAuthMode {

	@XmlElement(name = "auth_mode_type") public String type;

	public String name;

	@XmlElementWrapper(name = "credentials")
	@XmlElement(name = "credential") public List<SpreedlyGatewayCredential> credentials = new ArrayList<SpreedlyGatewayCredential>();
}