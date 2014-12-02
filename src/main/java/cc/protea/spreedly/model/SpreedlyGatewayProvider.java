package cc.protea.spreedly.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlTransient;

public class SpreedlyGatewayProvider {

	@XmlElement(name="gateway_type") public String gatewayType;
	public String name;
	@XmlElement(name="auth_mode") @XmlElementWrapper(name = "auth_modes") public List<SpreedlyGatewayAuthMode> authModes;
	@XmlElement(name="characteristics") public SpreedlyGatewayCharacteristics characteristics;
	@XmlElementWrapper(name = "payment_methods")
	@XmlElement(name = "payment_method")
	public List<SpreedlyGatewayPaymentMethod> paymentMethods = new ArrayList<SpreedlyGatewayPaymentMethod>();
	@XmlElementWrapper(name = "gateway_specific_fields")
	@XmlElement(name = "gateway_specific_field")
	public List<String> gatewaySpecificFields = new ArrayList<String>();
	@XmlTransient
	public List<String> supportedCountries = new ArrayList<String>();
	@XmlTransient
	public List<String> regions = new ArrayList<String>();
	public String homepage;
	@XmlElement(name = "company_name") public String companyName;

	@XmlElement(name = "regions")
	public void setRegions(final String in) {
		split(in, regions);
	}

	@XmlElement(name = "supported_countries")
	public void setSupportedCountries(final String in) {
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