package cc.protea.spreedly.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class SpreedlyCreditCard {

	@XmlElement(name = "first_name") public String firstName;
	@XmlElement(name = "last_name") public String lastName;
	@XmlElement(name = "full_name") public String fullName;
	public String number;
	@XmlElement(name = "track_data") public String trackData;
	public Integer month;
	public Integer year;
	@XmlElement(name = "verification_value") public String verificationValue;
    @XmlElement(name = "card_type") public SpreedlyCardType cardType;
    public String address1;
    public String address2;
    public String city;
    public String state;
    public String zip;
    public String country;
    @XmlElement(name = "phone_number") public String phoneNumber;
    @XmlElement(name = "shipping_address1") public String shippingAddress1;
    @XmlElement(name = "shipping_address2") public String shippingAddress2;
    @XmlElement(name = "shipping_city") public String shippingCity;
    @XmlElement(name = "shipping_state") public String shippingState;
    @XmlElement(name = "shipping_zip") public String shippingZip;
    @XmlElement(name = "shipping_country") public String shippingCountry;
    @XmlElement(name = "shipping_phone_number") public String shippingPhoneNumber;
    public String email;
    public Object data;
}
