package cc.protea.spreedly.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlEnum(String.class)
public enum SpreedlyStorageState {

	@XmlEnumValue("retained") RETAINED,
	@XmlEnumValue("cached") CACHED,
	@XmlEnumValue("redacted") REDACTED
}
