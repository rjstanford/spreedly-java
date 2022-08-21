package cc.protea.spreedly.model;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "mastercard")
@XmlAccessorType(XmlAccessType.FIELD)
public class SpreedlyMastercardNetwork {

	@XmlElement(name = "acquirer_merchant_id") public String acquirerMerchantId;
	@XmlElement(name = "country_code") public Long countryCode;
	@XmlElement(name = "mcc") public Long mcc;
	@XmlElement(name = "merchant_name") public String name;

	public String getAcquirerMerchantId() {
		return acquirerMerchantId;
	}

	public void setAcquirerMerchantId(String acquirerMerchantId) {
		this.acquirerMerchantId = acquirerMerchantId;
	}

	public Long getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(Long countryCode) {
		this.countryCode = countryCode;
	}

	public Long getMcc() {
		return mcc;
	}

	public void setMcc(Long mcc) {
		this.mcc = mcc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



}