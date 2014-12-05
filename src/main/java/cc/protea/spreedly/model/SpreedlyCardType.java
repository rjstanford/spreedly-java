package cc.protea.spreedly.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlEnum(String.class)
public enum SpreedlyCardType {

	@XmlEnumValue("visa") VISA,
	@XmlEnumValue("master") MASTERCARD,
	@XmlEnumValue("american_express") AMEX,
	@XmlEnumValue("discover") DISCOVER,
	@XmlEnumValue("dankort") DANKORT,
	@XmlEnumValue("jcb") JCB,
	@XmlEnumValue("diners_club") DINERS_CLUB

}