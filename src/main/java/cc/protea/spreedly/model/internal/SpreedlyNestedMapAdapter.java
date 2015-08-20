package cc.protea.spreedly.model.internal;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.HashMap;
import java.util.Map;


/**
 * Spreedly sometimes returns an element containing (probably only one) elements that contain effectively random key/value pairs as &lt;key&gt;value&lt;key&gt;. The name of the
 * wrapping element is unknown and generally corresponds to the gateway, but new gateways may be added at any time. The data is also unknown and may change over time.
 * @author rjstanford
 *
 */
public class SpreedlyNestedMapAdapter extends XmlAdapter<Object, Map<String, String>> {

	@Override
	public Map<String, String> unmarshal(final Object domTree) throws Exception {
		if (domTree == null) {
			return null;
		}
		// The 'content' should be 'gateway_specific_response_fields'
		Element gatewaySpecificResponseFields = (Element) domTree;
		Map<String, String> map = new HashMap<String, String>();
		// We are expecting to get zero or more direct children (with unknown names)
		NodeList gateways = gatewaySpecificResponseFields.getChildNodes();
		if (gateways == null || gateways.getLength() == 0) {
			return null;
		}
		for (int i = 0; i < gateways.getLength(); ++i) {
			Node gateway = gateways.item(i);
			if (gateway == null) {
				continue;
			}
			// Each gateway should have zero or more direct children (with unknown but useful names)
			NodeList responseFields = gateway.getChildNodes();
			if (responseFields == null) {
				continue;
			}
			for (int j = 0; j < responseFields.getLength(); ++j) {
				Node responseField = responseFields.item(j);
				if (responseField == null) {
					continue;
				}
				if (responseField.getNodeType() == Node.TEXT_NODE) {
					continue;
				}
				if (! responseField.hasChildNodes()) {
					continue;
				}
				String key = responseField.getNodeName();
				String value = responseField.getFirstChild().getNodeValue();
				if (key == null || value == null) {
					continue;
				}
				map.put(key, value);
			}
		}
		return map.isEmpty() ? null : map;
	}

	private DocumentBuilder documentBuilder;


	@Override
	public Object marshal(final Map<String, String> v) throws Exception {
		return null;
	}

	public SpreedlyNestedMapAdapter() {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			documentBuilder = dbf.newDocumentBuilder();
		} catch(Exception e) {
			// TODO - Handle Exception
		}
	}

}
