package cc.protea.spreedly.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlEnum(String.class)
public enum SpreedlyCvvResponse {

	@XmlEnumValue("D") SUSPICIOUS_TRANSACTION,
	@XmlEnumValue("I") FAILED_DATA_VALIDATION_CHECK,
	@XmlEnumValue("M") MATCH,
	@XmlEnumValue("N") NO_MATCH,
	@XmlEnumValue("P") NOT_PROCESSED,
	@XmlEnumValue("S") SHOULD_HAVE_BEEN_PRESENT,
	@XmlEnumValue("U") ISSUER_UNABLE_TO_PROCESS_REQUEST,
	@XmlEnumValue("X") CARD_DOES_NOT_SUPPORT_VERIFICATION

}
