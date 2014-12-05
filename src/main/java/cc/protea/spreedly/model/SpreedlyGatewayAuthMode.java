package cc.protea.spreedly.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

/**
 * Describes fields that are required to authenticate with a gateways. There may be multiple modes.
 * @author rjstanford
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class SpreedlyGatewayAuthMode {

	/**
	 * Spreedly assigned word identifying the collection of credentials.
	 */
	@XmlElement(name = "auth_mode_type") public String type;

	/**
	 * Spreedly assigned phrase identifying the collection of credentials.
	 */
	public String name;

	/**
	 * These credentials are stored to be able to authenticate when performing gateway transactions.
	 */
	@XmlElementWrapper(name = "credentials")
	@XmlElement(name = "credential") public List<SpreedlyGatewayCredential> credentials = new ArrayList<SpreedlyGatewayCredential>();

	/**
	 * @return Spreedly assigned word identifying the collection of credentials.
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type Spreedly assigned word identifying the collection of credentials.
	 */
	public void setType(final String type) {
		this.type = type;
	}

	/**
	 * @return Spreedly assigned phrase identifying the collection of credentials.
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name Spreedly assigned phrase identifying the collection of credentials.
	 */
	public void setName(final String name) {
		this.name = name;
	}

	/**
	 * @return These credentials are stored to be able to authenticate when performing gateway transactions.
	 */
	public List<SpreedlyGatewayCredential> getCredentials() {
		return credentials;
	}
	/**
	 * @param credentials These credentials are stored to be able to authenticate when performing gateway transactions.
	 */
	public void setCredentials(final List<SpreedlyGatewayCredential> credentials) {
		this.credentials = credentials;
	}


}