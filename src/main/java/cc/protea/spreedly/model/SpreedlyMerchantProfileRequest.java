package cc.protea.spreedly.model;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "merchant_profile")
@XmlAccessorType(XmlAccessType.FIELD)
public class SpreedlyMerchantProfileRequest {
	@XmlElement(name = "description") public String description;
	@XmlElementWrapper(name = "amex")
	@XmlElement(name = "amex")
	public SpreedlyAmexNetwork amex;
	@XmlElementWrapper(name = "visa")
	@XmlElement(name = "visa")
	public SpreedlyVisaNetwork visa;
	@XmlElementWrapper(name = "mastercard")
	@XmlElement(name = "mastercard")
	public SpreedlyMastercardNetwork mastercard;

	public SpreedlyAmexNetwork getAmex() {
		return amex;
	}

	public void setAmex(SpreedlyAmexNetwork amex) {
		this.amex = amex;
	}

	public SpreedlyVisaNetwork getVisa() {
		return visa;
	}

	public void setVisa(SpreedlyVisaNetwork visa) {
		this.visa = visa;
	}

	public SpreedlyMastercardNetwork getMastercard() {
		return mastercard;
	}

	public void setMastercard(SpreedlyMastercardNetwork mastercard) {
		this.mastercard = mastercard;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(final String description) {
		this.description = description;
	}
}