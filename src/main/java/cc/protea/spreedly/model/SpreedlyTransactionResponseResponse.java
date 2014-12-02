package cc.protea.spreedly.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class SpreedlyTransactionResponseResponse {

	public boolean success;
    public String message;
    @XmlElement(name = "avs_code") public SpreedlyAvsResponse avsResponse;
    @XmlElement(name = "avs_message") public String avsMessage;
    @XmlElement(name = "cvv_code") public SpreedlyCvvResponse cvvResponse;
    @XmlElement(name = "cvv_message") public String cvvMessage;
    public boolean pending;
    @XmlElement(name = "error_code") public String errorCode;
    @XmlElement(name = "error_detail") public String errorDetail;
    public boolean cancelled;
	@XmlElement(name = "created_at") public Date createdOn;
	@XmlElement(name = "updated_at") public Date updatedOn;

}