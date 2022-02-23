package cc.protea.spreedly.model.internal;

import cc.protea.spreedly.model.SpreedlyGatewayAccount;
import cc.protea.spreedly.model.SpreedlyGatewayCredential;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "gateway")
public class SpreedlyGatewayAccountUpdate {

	DocumentBuilder documentBuilder;
	public String mode;

	public SpreedlyGatewayAccountUpdate() {
		try {
			documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}

	public SpreedlyGatewayAccountUpdate(final SpreedlyGatewayAccount in) {
		this.gatewayType = in.gatewayType;
		this.mode = in.getMode();
		for (SpreedlyGatewayCredential credential : in.credentials) {
			SpreedlyInternalKeyValuePair pair = new SpreedlyInternalKeyValuePair();
			pair.key = credential.name;
			pair.value = credential.value;
			credentials.add(pair);
		}
	}

	@XmlElement(name = "gateway_type")
	public String gatewayType;

//	@XmlElementWrapper(name = "credentials")
	@XmlAnyElement
	@XmlJavaTypeAdapter(SpreedlyInternalKeyValuePairAdapter.class)
	public List<SpreedlyInternalKeyValuePair> credentials = new ArrayList<SpreedlyInternalKeyValuePair>();

}
