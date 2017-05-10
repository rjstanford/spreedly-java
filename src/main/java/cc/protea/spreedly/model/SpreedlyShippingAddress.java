
package cc.protea.spreedly.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "shipping_address")
@XmlAccessorType(XmlAccessType.FIELD)
public class SpreedlyShippingAddress
{
	public String name;
	public String address1;
	public String address2;
	public String city;
	public String state;
	public String zip;
	public String country;
	@XmlElement(name = "phone_number")
	public String phoneNumber;


	public String getPhoneNumber()
	{
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}

}
