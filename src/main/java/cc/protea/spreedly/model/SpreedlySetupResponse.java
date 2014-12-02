package cc.protea.spreedly.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class SpreedlySetupResponse {

	public boolean success;
	public SpreedlyMessage message;
	@XmlElement(name = "error_code") public String errorCode;
	@XmlElement(name = "checkout_url") public String checkoutUrl;
	@XmlElement(name = "created_at") public Date createdOn;
	@XmlElement(name = "updated_at") public Date updatedOn;

}
