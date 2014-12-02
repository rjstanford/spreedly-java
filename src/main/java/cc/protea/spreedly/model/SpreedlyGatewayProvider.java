package cc.protea.spreedly.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlTransient;

@XmlAccessorType(XmlAccessType.FIELD)
public class SpreedlyGatewayProvider {

	/**
	 * A unique identifier for a gateway provider.
	 */
	@XmlElement(name="gateway_type") public String gatewayType;
	/**
	 * The full descriptive name of a gateway provider.
	 */
	public String name;
	/**
	 * Fields that are required to authenticate with a gateways. There may be multiple modes. These credentials are stored to be able to authenticate when performing gateway transactions.
	 */
	@XmlElement(name="auth_mode") @XmlElementWrapper(name = "auth_modes") public List<SpreedlyGatewayAuthMode> authModes;
	/**
	 * A list of properties containing boolean values describing what properties the gateway supports.
	 */
	@XmlElement(name="characteristics") public SpreedlyGatewayCharacteristics characteristics;
	/**
	 * List of payment method types that the gateway supports.
	 */
	@XmlElementWrapper(name = "payment_methods")
	@XmlElement(name = "payment_method")
	public List<SpreedlyGatewayPaymentMethod> paymentMethods = new ArrayList<SpreedlyGatewayPaymentMethod>();
	/**
	 * Fields that a gateway defines for a specific purpose but is not implemented by all gateways.
	 */
	@XmlElementWrapper(name = "gateway_specific_fields")
	@XmlElement(name = "gateway_specific_field")
	public List<String> gatewaySpecificFields = new ArrayList<String>();
	/**
	 * Abbreviated country names where the gateway can process payments.
	 */
	@XmlTransient
	public List<String> supportedCountries = new ArrayList<String>();
	/**
	 * Global regions where the gateway can process payments.
	 */
	@XmlTransient
	public List<String> regions = new ArrayList<String>();
	/**
	 * URL of the gateway's website.
	 */
	public String homepage;
	/**
	 * Name of the company that operates the gateway provider.
	 */
	@XmlElement(name = "company_name") public String companyName;

	/**
	 * @return A unique identifier for a gateway provider.
	 */
	public String getGatewayType() {
		return gatewayType;
	}
	/**
	 * @param gatewayType A unique identifier for a gateway provider.
	 */
	public void setGatewayType(final String gatewayType) {
		this.gatewayType = gatewayType;
	}

	/**
	 * @return The full descriptive name of a gateway provider.
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name The full descriptive name of a gateway provider.
	 */
	public void setName(final String name) {
		this.name = name;
	}

	/**
	 * @return Fields that are required to authenticate with a gateways. There may be multiple modes. These credentials are stored to be able to authenticate when performing gateway transactions.
	 */
	public List<SpreedlyGatewayAuthMode> getAuthModes() {
		return authModes;
	}
	/**
	 * @param authModes Fields that are required to authenticate with a gateways. There may be multiple modes. These credentials are stored to be able to authenticate when performing gateway transactions.
	 */
	public void setAuthModes(final List<SpreedlyGatewayAuthMode> authModes) {
		this.authModes = authModes;
	}

	/**
	 * @return A list of properties containing boolean values describing what properties the gateway supports.
	 */
	public SpreedlyGatewayCharacteristics getCharacteristics() {
		return characteristics;
	}
	/**
	 * @param characteristics A list of properties containing boolean values describing what properties the gateway supports.
	 */
	public void setCharacteristics(final SpreedlyGatewayCharacteristics characteristics) {
		this.characteristics = characteristics;
	}

	/**
	 * @return List of payment method types that the gateway supports.
	 */
	public List<SpreedlyGatewayPaymentMethod> getPaymentMethods() {
		return paymentMethods;
	}
	/**
	 * @param paymentMethods List of payment method types that the gateway supports.
	 */
	public void setPaymentMethods(final List<SpreedlyGatewayPaymentMethod> paymentMethods) {
		this.paymentMethods = paymentMethods;
	}

	/**
	 * @return Fields that a gateway defines for a specific purpose but is not implemented by all gateways.
	 */
	public List<String> getGatewaySpecificFields() {
		return gatewaySpecificFields;
	}
	/**
	 * @param gatewaySpecificFields Fields that a gateway defines for a specific purpose but is not implemented by all gateways.
	 */
	public void setGatewaySpecificFields(final List<String> gatewaySpecificFields) {
		this.gatewaySpecificFields = gatewaySpecificFields;
	}

	/**
	 * @return Abbreviated country names where the gateway can process payments.
	 */
	public List<String> getSupportedCountries() {
		return supportedCountries;
	}
	/**
	 * @param supportedCountries Abbreviated country names where the gateway can process payments.
	 */
	public void setSupportedCountries(final List<String> supportedCountries) {
		this.supportedCountries = supportedCountries;
	}

	/**
	 * @return Global regions where the gateway can process payments.
	 */
	public List<String> getRegions() {
		return regions;
	}
	/**
	 * @param regions Global regions where the gateway can process payments.
	 */
	public void setRegions(final List<String> regions) {
		this.regions = regions;
	}

	/**
	 * @return URL of the gateway's website.
	 */
	public String getHomepage() {
		return homepage;
	}
	/**
	 * @param homepage URL of the gateway's website.
	 */
	public void setHomepage(final String homepage) {
		this.homepage = homepage;
	}

	/**
	 * @return Name of the company that operates the gateway provider.
	 */
	public String getCompanyName() {
		return companyName;
	}
	/**
	 * @param companyName Name of the company that operates the gateway provider.
	 */
	public void setCompanyName(final String companyName) {
		this.companyName = companyName;
	}


	// Private XML hassles below here

	@XmlElement(name = "regions")
	private void setRegionString(final String in) {
		split(in, regions);
	}

	@XmlElement(name = "supported_countries")
	private void setSupportedCountryString(final String in) {
		split(in, supportedCountries);
	}

	private void split(final String in, final List<String> list) {
		if (in == null) {
			list.clear();
			return;
		}
		for (String item : in.split(",")) {
			list.add(item.trim());
		}
	}

}