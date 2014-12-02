package cc.protea.spreedly.model;

import javax.xml.bind.annotation.XmlElement;

public class SpreedlyGatewayCharacteristics {
	@XmlElement(name = "supports_purchase") public boolean supportsPurchase;
	@XmlElement(name = "supports_authorize") public boolean supportsAuthorize;
	@XmlElement(name = "supports_capture") public boolean supportsCapture;
	@XmlElement(name = "supports_credit") public boolean supportsCredit;
	@XmlElement(name = "supports_general_credit") public boolean supportsGeneralCredit;
	@XmlElement(name = "supports_void") public boolean supportsVoid;
	@XmlElement(name = "supports_verify") public boolean supportsVerify;
	@XmlElement(name = "supports_reference_purchase") public boolean supportsReferencePurchase;
	@XmlElement(name = "supports_purchase_via_preauthorization") public boolean supportsPurchaseViaPreauthorization;
	@XmlElement(name = "supports_offsite_purchase") public boolean supportsOffsitePurchase;
	@XmlElement(name = "supports_offsite_authorize") public boolean supportsOffsiteAuthorize;
	@XmlElement(name = "supports_3dsecure_purchase") public boolean supports3DSecurePurchase;
	@XmlElement(name = "supports_3dsecure_authorize") public boolean supports3DSecureAuthorize;
	@XmlElement(name = "supports_store") public boolean supportsStore;
	@XmlElement(name = "supports_remove") public boolean supportsRemove;
}