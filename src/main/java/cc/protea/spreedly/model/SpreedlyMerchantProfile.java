package cc.protea.spreedly.model;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@XmlRootElement(name = "merchant_profile")
@XmlAccessorType(XmlAccessType.FIELD)
public class SpreedlyMerchantProfile {
	@XmlElement(name = "description") public String description;
	@XmlElement(name = "token") public String token;
	@XmlElement(name = "card_networks")
	SpreedlyCreditNetwork creditNetwork;
	@XmlElement(name = "created_at") public Date createdOn;
	@XmlElement(name = "updated_at") public Date updatedOn;


	public SpreedlyCreditNetwork getCreditNetwork() {
		return creditNetwork;
	}
	public void setCreditNetwork(SpreedlyCreditNetwork creditNetwork) {
		this.creditNetwork = creditNetwork;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(final String description) {
		this.description = description;
	}

}