package cc.protea.spreedly.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlEnum(String.class)
public enum SpreedlyTransactionState {

	@XmlEnumValue("succeeded") SUCCEEDED,
	@XmlEnumValue("failed") FAILED,
	@XmlEnumValue("gateway_processing_failed") GATEWAY_PROCESSING_FAILED,
	@XmlEnumValue("gateway_processing_result_unknown") GATEWAY_PROCESSING_RESULT_UNKNOWN

}
