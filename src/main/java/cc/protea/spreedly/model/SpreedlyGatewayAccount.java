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

}