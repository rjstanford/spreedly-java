package cc.protea.spreedly.model.internal;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlJavaTypeAdapter(SpreedlyInternalKeyValuePairAdapter.class)
public class SpreedlyInternalKeyValuePair {

	public String key;
	public String value;
}
