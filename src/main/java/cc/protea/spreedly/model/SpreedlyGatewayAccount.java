package cc.protea.spreedly.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "gateway")
@XmlAccessorType(XmlAccessType.FIELD)
public class SpreedlyGatewayAccount {

	public String token;
	@XmlElement(name = "gateway_type") public String gatewayType;
	public String name;
	public SpreedlyGatewayCharacteristics characteristics = new SpreedlyGatewayCharacteristics();
	@XmlElementWrapper(name = "credentials")
	@XmlElement(name = "credential")
	public List<SpreedlyGatewayCredential> credentials = new ArrayList<SpreedlyGatewayCredential>();
	@XmlElementWrapper(name = "gateway_specific_fields")
	@XmlElement(name = "gateway_specific_field")
	public List<String> gatewaySpecificFields = new ArrayList<String>();
	@XmlElementWrapper(name = "payment_methods")
	@XmlElement(name = "payment_method")
	public List<SpreedlyGatewayPaymentMethod> paymentMethods = new ArrayList<SpreedlyGatewayPaymentMethod>();
	public SpreedlyGatewayAccountState state;
	public boolean redacted;
	@XmlElement(name = "created_at") public Date createdOn;
	@XmlElement(name = "updated_at") public Date updatedOn;
	@XmlElement(name = "description") public String description;
	public String mode;
	@XmlElement(name = "sandbox") public Boolean sandbox;

	public String getToken() {
		return token;
	}
	public void setToken(final String token) {
		this.token = token;
	}
	public String getGatewayType() {
		return gatewayType;
	}
	public void setGatewayType(final String gatewayType) {
		this.gatewayType = gatewayType;
	}
	public String getName() {
		return name;
	}
	public void setName(final String name) {
		this.name = name;
	}
	public SpreedlyGatewayCharacteristics getCharacteristics() {
		return characteristics;
	}
	public void setCharacteristics(final SpreedlyGatewayCharacteristics characteristics) {
		this.characteristics = characteristics;
	}
	public List<SpreedlyGatewayCredential> getCredentials() {
		return credentials;
	}
	public void setCredentials(final List<SpreedlyGatewayCredential> credentials) {
		this.credentials = credentials;
	}
	public List<String> getGatewaySpecificFields() {
		return gatewaySpecificFields;
	}
	public void setGatewaySpecificFields(final List<String> gatewaySpecificFields) {
		this.gatewaySpecificFields = gatewaySpecificFields;
	}
	public List<SpreedlyGatewayPaymentMethod> getPaymentMethods() {
		return paymentMethods;
	}
	public void setPaymentMethods(final List<SpreedlyGatewayPaymentMethod> paymentMethods) {
		this.paymentMethods = paymentMethods;
	}
	public SpreedlyGatewayAccountState getState() {
		return state;
	}
	public void setState(final SpreedlyGatewayAccountState state) {
		this.state = state;
	}
	public boolean isRedacted() {
		return redacted;
	}
	public void setRedacted(final boolean redacted) {
		this.redacted = redacted;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(final Date createdOn) {
		this.createdOn = createdOn;
	}
	public Date getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(final Date updatedOn) {
		this.updatedOn = updatedOn;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(final String description) {
		this.description = description;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public boolean isSandbox() {
		return sandbox;
	}

	public void setSandbox(boolean sandbox) {
		this.sandbox = sandbox;
	}
}
