package cc.protea.spreedly.model;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "sca_provider")
@XmlAccessorType(XmlAccessType.FIELD)
public class SpreedlyScaProviderRequest {

	@XmlElement(name = "merchant_profile_key") public String merchantProfileKey;
	@XmlElement(name = "type") public String type;
	@XmlElement(name = "sandbox") public boolean sandbox = false;
	@XmlElement(name = "visa")
	public SpreedlyVisaDetails visa;
	@XmlElement(name = "mastercard")
	public SpreedlyMastercardDetails mastercard;
	@XmlElement(name = "amex")
	public SpreedlyAmexDetails amex;

	public String getMerchantProfileKey() {
		return merchantProfileKey;
	}

	public void setMerchantProfileKey(String merchantProfileKey) {
		this.merchantProfileKey = merchantProfileKey;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean getSandbox() {
		return sandbox;
	}

	public void setSandbox(boolean sandbox) {
		this.sandbox = sandbox;
	}

	public SpreedlyVisaDetails getVisa() {
		return visa;
	}

	public void setVisa(SpreedlyVisaDetails visa) {
		this.visa = visa;
	}

	public SpreedlyMastercardDetails getMastercard() {
		return mastercard;
	}

	public void setMastercard(SpreedlyMastercardDetails mastercard) {
		this.mastercard = mastercard;
	}

	public SpreedlyAmexDetails getAmex() {
		return amex;
	}

	public void setAmex(SpreedlyAmexDetails amex) {
		this.amex = amex;
	}

}