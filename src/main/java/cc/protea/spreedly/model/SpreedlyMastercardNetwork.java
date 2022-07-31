package cc.protea.spreedly.model;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "mastercard")
@XmlAccessorType(XmlAccessType.FIELD)
public class SpreedlyMastercardNetwork {

	@XmlElement(name = "acquirer_merchant_id") public Long acquirerMerchantId;
	@XmlElement(name = "country_code") public String countryCode;
	@XmlElement(name = "mcc") public Long mcc;
	@XmlElement(name = "merchant_name") public String name;

	public Long getAcquirerMerchantId() {
		return acquirerMerchantId;
	}

	public void setAcquirerMerchantId(Long acquirerMerchantId) {
		this.acquirerMerchantId = acquirerMerchantId;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
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