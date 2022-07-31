package cc.protea.spreedly.model;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "card_networks")
@XmlAccessorType(XmlAccessType.FIELD)
public class SpreedlyCreditNetwork {

	@XmlElementWrapper(name = "visa")
	@XmlElement(name = "visa")
	public SpreedlyVisaNetwork visa;
	@XmlElementWrapper(name = "mastercard")
	@XmlElement(name = "mastercard")
	public SpreedlyMastercardNetwork mastercard;
	@XmlElementWrapper(name = "amex")
	@XmlElement(name = "amex")
	public SpreedlyAmexNetwork amex;

	public SpreedlyVisaNetwork getVisa() {
		return visa;
	}

	public void setVisa(SpreedlyVisaNetwork visa) {
		this.visa = visa;
	}

	public SpreedlyMastercardNetwork getMastercard() {
		return mastercard;
	}

	public void setMastercard(SpreedlyMastercardNetwork mastercard) {
		this.mastercard = mastercard;
	}

	public SpreedlyAmexNetwork getAmex() {
		return amex;
	}

	public void setAmex(SpreedlyAmexNetwork amex) {
		this.amex = amex;
	}


}