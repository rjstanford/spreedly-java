package cc.protea.spreedly.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlEnum(String.class)
public enum SpreedlyPaymentMethodState {

	@XmlEnumValue("cached") CACHED,
	@XmlEnumValue("retained") RETAINED,
	@XmlEnumValue("redacted") REDACTED

}
