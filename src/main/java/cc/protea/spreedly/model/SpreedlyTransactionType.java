package cc.protea.spreedly.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlEnum(String.class)
public enum SpreedlyTransactionType {

	@XmlEnumValue("Authorization") AUTHORIZATION,
	@XmlEnumValue("Capture") CAPTURE,
	@XmlEnumValue("Credit") CREDIT,
	@XmlEnumValue("RedactGateway") REDACT_GATEWAY,
	@XmlEnumValue("RecacheSensitiveData") RECACHE_SENSITIVE_DATA

}
