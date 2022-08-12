package cc.protea.spreedly.model;

import cc.protea.spreedly.model.internal.SpreedlyErrorSetting;
import cc.protea.spreedly.model.internal.SpreedlyNestedMapAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@XmlRootElement(name = "transaction")
@XmlAccessorType(XmlAccessType.FIELD)
public class SpreedlyScaAuthenticationResponse implements SpreedlyErrorSetting {

	/**
	 * Any positive whole number, for example 1234 = $12.34.
	 */
	@XmlElement(name = "amount") public Integer amountInCents;
	/**
	 * Date and time of origination.
	 */
	@XmlElement(name = "created_at") public Date createdOn;
	/**
	 * ISO 4217 Currency Code e.g., USD, MXN, EUR
	 */
	@XmlElement(name = "currency_code") public String currencyCode;
	/**
	 * true if transaction was successful.
	 */
	public boolean succeeded;
	/**
	 * 	The token uniquely identifying the transaction at Spreedly.
	 * 	This token can be passed into an authorize or purchase transaction via the sca_authentication_token field to automatically fill its payment_method_token and Third Party 3DS2 fields.
	 */
	public String token;
	/**
	 * 	SCA Provider token that performs a Spreedly 3DS2 Global authentication before attempting the gateway transaction.
	 * 	Please see our Spreedly 3DS2 Global Guide for more info.
	 */
	@XmlElement(name = "sca_provider_key") public String scaProviderKey;

	public SpreedlyMessage message;

	public Integer getAmountInCents() {
		return amountInCents;
	}

	public void setAmountInCents(Integer amountInCents) {
		this.amountInCents = amountInCents;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public boolean isSucceeded() {
		return succeeded;
	}

	public void setSucceeded(boolean succeeded) {
		this.succeeded = succeeded;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getScaProviderKey() {
		return scaProviderKey;
	}

	public void setScaProviderKey(String scaProviderKey) {
		this.scaProviderKey = scaProviderKey;
	}

	public SpreedlyMessage getMessage() {
		return message;
	}
	public SpreedlyScaAuthenticationResponse setMessage(final SpreedlyMessage message) {
		this.message = message;
		return this;
	}

	public void setError(final String key, final String error) {
		message = new SpreedlyMessage();
		message.key = key;
		message.message = error;
		this.succeeded = false;
	}
}
