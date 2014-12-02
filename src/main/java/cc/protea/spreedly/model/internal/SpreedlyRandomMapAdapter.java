package cc.protea.spreedly.model.internal;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


/**
 * Spreedly sometimes returns an element containing (probably only one) elements that contain effectively random key/value pairs as <key>value<key>. The name of the
 * wrapping element is unknown and generally corresponds to the gateway, but new gateways may be added at any time. The data is also unknown and may change over time.
 * @author rjstanford
 *
 */
public class SpreedlyRandomMapAdapter extends XmlAdapter<Object, Map<String, String>> {

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

	@Override
	public Object marshal(final Map<String, String> v) throws Exception {
		// We don't care - only unmarshalling these
		return null;
	}

}
