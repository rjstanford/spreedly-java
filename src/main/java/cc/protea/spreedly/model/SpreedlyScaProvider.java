package cc.protea.spreedly.model;

import javax.xml.bind.annotation.*;
import java.util.Date;

@XmlRootElement(name = "sca_provider")
@XmlAccessorType(XmlAccessType.FIELD)
public class SpreedlyScaProvider {

	@XmlElement(name = "token") public String token;
	@XmlElement(name = "type") public String type ;
	@XmlElement(name = "created_at") public Date createdOn;
	@XmlElement(name = "updated_at") public Date updatedOn;
	@XmlElementWrapper(name = "visa")
	@XmlElement(name = "visa")
	public SpreedlyVisaDetails visa;
	@XmlElementWrapper(name = "mastercard")
	@XmlElement(name = "mastercard")
	public SpreedlyMastercardDetails mastercard;

	public String isType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	@XmlElementWrapper(name = "amex")
	@XmlElement(name = "amex")
	public SpreedlyAmexDetails amex;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
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