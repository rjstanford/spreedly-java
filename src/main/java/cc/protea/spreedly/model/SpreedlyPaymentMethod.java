package cc.protea.spreedly.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "payment_method")
public class SpreedlyPaymentMethod {

	public String token;
	@XmlElement(name = "created_at") public Date createdOn;
	@XmlElement(name = "updated_at") public Date updatedOn;
    public String email;
    public String data;
    @XmlElement(name = "storage_state") public SpreedlyStorageState storageState;
    @XmlElement(name = "third_party_token") public String thirdPartyToken;
    public boolean test;
    @XmlElement(name = "last_four_digits") public String lastFourDigits;
    @XmlElement(name = "first_six_digits") public String firstSixDigits;
    @XmlElement(name = "card_type") public SpreedlyCardType cardType;
    @XmlElement(name = "first_name") public String firstName;
    @XmlElement(name = "last_name") public String lastName;
    public Integer month;
    public Integer year;
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
    @XmlElement(name = "full_name") public String fullName;
    @XmlElement(name = "eligible_for_card_updater") public boolean eligibleForCardUpdater;
    @XmlElement(name = "payment_method_type") public SpreedlyPaymentMethodType paymentMethodType;
    @XmlElement(name = "verification_value") public String verificationValue;
	@XmlElementWrapper(name = "errors")
	@XmlElement(name = "error")
	public List<String> errors = new ArrayList<String>();
	@XmlElement(name = "api_urls") public SpreedlyApiURLs apiUrls;
    public String number;
}