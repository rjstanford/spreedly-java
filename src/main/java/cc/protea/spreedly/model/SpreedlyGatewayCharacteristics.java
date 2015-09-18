package cc.protea.spreedly.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
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
	@XmlElement(name = "supports_disburse") public boolean supportsDisburse;
	@XmlElement(name = "supports_fraud_review") public boolean supportsFraudReview;

	public boolean isSupportsPurchase() {
		return supportsPurchase;
	}
	public void setSupportsPurchase(final boolean supportsPurchase) {
		this.supportsPurchase = supportsPurchase;
	}
	public boolean isSupportsAuthorize() {
		return supportsAuthorize;
	}
	public void setSupportsAuthorize(final boolean supportsAuthorize) {
		this.supportsAuthorize = supportsAuthorize;
	}
	public boolean isSupportsCapture() {
		return supportsCapture;
	}
	public void setSupportsCapture(final boolean supportsCapture) {
		this.supportsCapture = supportsCapture;
	}
	public boolean isSupportsCredit() {
		return supportsCredit;
	}
	public void setSupportsCredit(final boolean supportsCredit) {
		this.supportsCredit = supportsCredit;
	}
	public boolean isSupportsGeneralCredit() {
		return supportsGeneralCredit;
	}
	public void setSupportsGeneralCredit(final boolean supportsGeneralCredit) {
		this.supportsGeneralCredit = supportsGeneralCredit;
	}
	public boolean isSupportsVoid() {
		return supportsVoid;
	}
	public void setSupportsVoid(final boolean supportsVoid) {
		this.supportsVoid = supportsVoid;
	}
	public boolean isSupportsVerify() {
		return supportsVerify;
	}
	public void setSupportsVerify(final boolean supportsVerify) {
		this.supportsVerify = supportsVerify;
	}
	public boolean isSupportsReferencePurchase() {
		return supportsReferencePurchase;
	}
	public void setSupportsReferencePurchase(final boolean supportsReferencePurchase) {
		this.supportsReferencePurchase = supportsReferencePurchase;
	}
	public boolean isSupportsPurchaseViaPreauthorization() {
		return supportsPurchaseViaPreauthorization;
	}
	public void setSupportsPurchaseViaPreauthorization(final boolean supportsPurchaseViaPreauthorization) {
		this.supportsPurchaseViaPreauthorization = supportsPurchaseViaPreauthorization;
	}
	public boolean isSupportsOffsitePurchase() {
		return supportsOffsitePurchase;
	}
	public void setSupportsOffsitePurchase(final boolean supportsOffsitePurchase) {
		this.supportsOffsitePurchase = supportsOffsitePurchase;
	}
	public boolean isSupportsOffsiteAuthorize() {
		return supportsOffsiteAuthorize;
	}
	public void setSupportsOffsiteAuthorize(final boolean supportsOffsiteAuthorize) {
		this.supportsOffsiteAuthorize = supportsOffsiteAuthorize;
	}
	public boolean isSupports3DSecurePurchase() {
		return supports3DSecurePurchase;
	}
	public void setSupports3DSecurePurchase(final boolean supports3dSecurePurchase) {
		supports3DSecurePurchase = supports3dSecurePurchase;
	}
	public boolean isSupports3DSecureAuthorize() {
		return supports3DSecureAuthorize;
	}
	public void setSupports3DSecureAuthorize(final boolean supports3dSecureAuthorize) {
		supports3DSecureAuthorize = supports3dSecureAuthorize;
	}
	public boolean isSupportsStore() {
		return supportsStore;
	}
	public void setSupportsStore(final boolean supportsStore) {
		this.supportsStore = supportsStore;
	}
	public boolean isSupportsRemove() {
		return supportsRemove;
	}
	public void setSupportsRemove(final boolean supportsRemove) {
		this.supportsRemove = supportsRemove;
	}
	public boolean isSupportsDisburse() {
		return supportsDisburse;
	}
	public void setsSupportsDisburse(final boolean supportsDisburse) {
		this.supportsDisburse = supportsDisburse;
	}
	public boolean isSupportsFraudReview() {
		return supportsFraudReview;
	}
	public void setsSupportsFraudReview(final boolean supportsFraudReview) {
		this.supportsFraudReview = supportsFraudReview;
	}


}
