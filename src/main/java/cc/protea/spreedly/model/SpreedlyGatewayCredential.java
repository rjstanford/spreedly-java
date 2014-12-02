package cc.protea.spreedly.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class SpreedlyGatewayCredential {

	/**
	 * The Spreedly key for the credential.
	 */
	public String name;
	/**
	 * A human name for the field.
	 */
	public String label;
	/**
	 * The value associated with the named credential
	 */
	public String value;
	/**
	 * Indicates that you can safely show the credentials to users (i.e. you can use a cleartext field rather than a password field).
	 * Safe fields will also be returned when you pull the gateway, whereas non-safe fields will never be returned to you.
	 */
	public boolean safe;
	/**
	 * Indicates a large credential that needs a large text field, such as a certificate that needs to be pasted in.
	 */
	public boolean large;

	/**
	 * @return The Spreedly key for the credential.
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name The Spreedly key for the credential.
	 */
	public void setName(final String name) {
		this.name = name;
	}

	/**
	 * @return a human name for the field.
	 */
	public String getLabel() {
		return label;
	}
	/**
	 * @param label a human name for the field.
	 */
	public void setLabel(final String label) {
		this.label = label;
	}

	/**
	 * @return the value associated with the named credential
	 */
	public String getValue() {
		return value;
	}
	/**
	 * @param value the value associated with the named credential
	 */
	public void setValue(final String value) {
		this.value = value;
	}

	/**
	 * @return Indicates that you can safely show the credentials to users (i.e. you can use a cleartext field rather than a password field).
	 * Safe fields will also be returned when you pull the gateway, whereas non-safe fields will never be returned to you.
	 */
	public boolean isSafe() {
		return safe;
	}
	/**
	 * @param safe Indicates that you can safely show the credentials to users (i.e. you can use a cleartext field rather than a password field).
	 * Safe fields will also be returned when you pull the gateway, whereas non-safe fields will never be returned to you.
	 */
	public void setSafe(final boolean safe) {
		this.safe = safe;
	}

	/**
	 * @return indicates a large credential that needs a large text field, such as a certificate that needs to be pasted in.
	 */
	public boolean isLarge() {
		return large;
	}
	/**
	 * @param large indicates a large credential that needs a large text field, such as a certificate that needs to be pasted in.
	 */
	public void setLarge(final boolean large) {
		this.large = large;
	}

}