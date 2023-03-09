package cc.protea.spreedly.model;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "borgun")
@XmlAccessorType(XmlAccessType.FIELD)
public class SpreedlyBorgunSpecificFields {

	@XmlElement(name = "terminal_id") public String terminalId;

	@XmlElement(name = "passenger_itinerary_data") public String passengerItineraryData;

	@XmlElement(name = "merchant_return_url") public String merchantReturnUrl;

	@XmlElement(name = "three_ds_message_id") public String threeDsMessageId;

	public String getTerminalId() {
		return terminalId;
	}

	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}

	public String getPassengerItineraryData() {
		return passengerItineraryData;
	}

	public void setPassengerItineraryData(String passengerItineraryData) {
		this.passengerItineraryData = passengerItineraryData;
	}

	public String getMerchantReturnUrl() {
		return merchantReturnUrl;
	}

	public void setMerchantReturnUrl(String merchantReturnUrl) {
		this.merchantReturnUrl = merchantReturnUrl;
	}

	public String getThreeDsMessageId() {
		return threeDsMessageId;
	}

	public void setThreeDsMessageId(String threeDsMessageId) {
		this.threeDsMessageId = threeDsMessageId;
	}
}
