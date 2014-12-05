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
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(final String fullName) {
		this.fullName = fullName;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(final String number) {
		this.number = number;
	}
	public String getTrackData() {
		return trackData;
	}
	public void setTrackData(final String trackData) {
		this.trackData = trackData;
	}
	public Integer getMonth() {
		return month;
	}
	public void setMonth(final Integer month) {
		this.month = month;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(final Integer year) {
		this.year = year;
	}
	public String getVerificationValue() {
		return verificationValue;
	}
	public void setVerificationValue(final String verificationValue) {
		this.verificationValue = verificationValue;
	}
	public SpreedlyCardType getCardType() {
		return cardType;
	}
	public void setCardType(final SpreedlyCardType cardType) {
		this.cardType = cardType;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(final String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(final String address2) {
		this.address2 = address2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(final String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(final String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(final String zip) {
		this.zip = zip;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(final String country) {
		this.country = country;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(final String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getShippingAddress1() {
		return shippingAddress1;
	}
	public void setShippingAddress1(final String shippingAddress1) {
		this.shippingAddress1 = shippingAddress1;
	}
	public String getShippingAddress2() {
		return shippingAddress2;
	}
	public void setShippingAddress2(final String shippingAddress2) {
		this.shippingAddress2 = shippingAddress2;
	}
	public String getShippingCity() {
		return shippingCity;
	}
	public void setShippingCity(final String shippingCity) {
		this.shippingCity = shippingCity;
	}
	public String getShippingState() {
		return shippingState;
	}
	public void setShippingState(final String shippingState) {
		this.shippingState = shippingState;
	}
	public String getShippingZip() {
		return shippingZip;
	}
	public void setShippingZip(final String shippingZip) {
		this.shippingZip = shippingZip;
	}
	public String getShippingCountry() {
		return shippingCountry;
	}
	public void setShippingCountry(final String shippingCountry) {
		this.shippingCountry = shippingCountry;
	}
	public String getShippingPhoneNumber() {
		return shippingPhoneNumber;
	}
	public void setShippingPhoneNumber(final String shippingPhoneNumber) {
		this.shippingPhoneNumber = shippingPhoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(final String email) {
		this.email = email;
	}
	public Object getData() {
		return data;
	}
	public void setData(final Object data) {
		this.data = data;
	}


}
