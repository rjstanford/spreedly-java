package cc.protea.spreedly.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlEnum(String.class)
public enum SpreedlyPaymentMethodType {

	@XmlEnumValue("credit_card") CREDIT_CARD,
	@XmlEnumValue("bank_account") BANK_ACCOUNT,
	@XmlEnumValue("dwolla") DWOLLA,
	@XmlEnumValue("paypal") PAYPAL
}
