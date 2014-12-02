package cc.protea.spreedly.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;

public class SpreedlySetupResponse {

	public boolean success;
	public SpreedlyMessage message;
	@XmlElement(name = "error_code") public String errorCode;
	@XmlElement(name = "checkout_url") public String checkoutUrl;
	@XmlElement(name = "created_at") public Date createdOn;
	@XmlElement(name = "updated_at") public Date updatedOn;

}
