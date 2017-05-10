package cc.protea.spreedly.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "shipping_address")
@XmlAccessorType(XmlAccessType.FIELD)
public class SpreedlyShippingAddress
{
	 @XmlElement(name = "name") public String name;
	 @XmlElement(name = "address1") public String address1;
	 @XmlElement(name = "address2") public String address2;
	 @XmlElement(name = "city") public String city;
	 @XmlElement(name = "state") public String state;
	 @XmlElement(name = "zip") public String zip;
	 @XmlElement(name = "country") public String country;
	 @XmlElement(name = "phone_number") public String phone_number;

}
