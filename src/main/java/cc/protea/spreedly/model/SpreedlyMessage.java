package cc.protea.spreedly.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

public class SpreedlyMessage {

	@XmlAttribute
	public String key;

	@XmlValue
	public String message;

	public String toString() {
		return message;
	}
}
