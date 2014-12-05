package cc.protea.spreedly.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class SpreedlyTransactionResponseDetails {

	public boolean success;
	public SpreedlyMessage message;
	@XmlElement(name = "error_code") public String errorCode;
	@XmlElement(name = "checkout_url") public String checkoutUrl;
	/**
	 * Date and time of origination.
	 */
	@XmlElement(name = "created_at") public Date createdOn;
	/**
	 * Date and time of modification.
	 */
	@XmlElement(name = "updated_at") public Date updatedOn;

	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(final boolean success) {
		this.success = success;
	}
	public SpreedlyMessage getMessage() {
		return message;
	}
	public void setMessage(final SpreedlyMessage message) {
		this.message = message;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(final String errorCode) {
		this.errorCode = errorCode;
	}
	public String getCheckoutUrl() {
		return checkoutUrl;
	}
	public void setCheckoutUrl(final String checkoutUrl) {
		this.checkoutUrl = checkoutUrl;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(final Date createdOn) {
		this.createdOn = createdOn;
	}
	public Date getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(final Date updatedOn) {
		this.updatedOn = updatedOn;
	}


}
