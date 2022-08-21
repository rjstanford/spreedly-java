package cc.protea.spreedly.model;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "mastercard")
@XmlAccessorType(XmlAccessType.FIELD)
public class SpreedlyMastercardDetails {

	@XmlElement(name = "acquirer_bin") public Long acquirerBin;
	@XmlElement(name = "merchant_url") public String merchantUrl;

	public Long getAcquirerBin() {
		return acquirerBin;
	}

	public void setAcquirerBin(Long acquirerBin) {
		this.acquirerBin = acquirerBin;
	}

	public String getMerchantUrl() {
		return merchantUrl;
	}

	public void setMerchantUrl(String merchantUrl) {
		this.merchantUrl = merchantUrl;
	}


}