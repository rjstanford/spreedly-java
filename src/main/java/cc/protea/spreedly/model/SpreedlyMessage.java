package cc.protea.spreedly.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
public class SpreedlyMessage {

	/**
	 * The constant Spreedly key representing the results, useful for translation.
	 */
	@XmlAttribute public String key;

	/**
	 * A brief description of the results of the transaction.
	 */
	@XmlValue public String message;

	/**
	 * @return A brief description of the results of the transaction.
	 */
	public String toString() {
		return message;
	}

	/**
	 * @return The constant Spreedly key representing the results, useful for translation.
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key The constant Spreedly key representing the results, useful for translation.
	 */
	public void setKey(final String key) {
		this.key = key;
	}

	/**
	 * @return A brief description of the results of the transaction.
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param A brief description of the results of the transaction.
	 */
	public void setMessage(final String message) {
		this.message = message;
	}


}
