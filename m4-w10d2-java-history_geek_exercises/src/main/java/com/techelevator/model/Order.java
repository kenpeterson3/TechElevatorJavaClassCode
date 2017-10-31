package com.techelevator.model;

import static com.techelevator.model.DollarAmount.ZERO_DOLLARS;

import java.util.Map;

public class Order {

	private Long id;
	private Long userID;
	private String nameOnCard;
	private String creditCardNumber;
	private String expirationDate;
	private String billingAddress1;
	private String billingAddress2;
	private String billingCity;
	private String billingState;
	private String billingPostalCode;
	private String shippingAddress1;
	private String shippingAddress2;
	private String shippingCity;
	private String shippingState;
	private String shippigPostalCode;
	private String shippingType;
	private DollarAmount subTotal = ZERO_DOLLARS;
	private double weight;
	private DollarAmount shipping = ZERO_DOLLARS;
    private DollarAmount tax = ZERO_DOLLARS;
    private Map<String, DollarAmount> shippingRates;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserID() {
		return userID;
	}
	public void setUserID(Long userID) {
		this.userID = userID;
	}
	//Required
	public String getNameOnCard() {
		return nameOnCard;
	}
	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}
	//Required
	public String getCreditCardNumber() {
		return creditCardNumber;
	}
	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
	//Required
	public String getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	//Required
	public String getBillingAddress1() {
		return billingAddress1;
	}
	public void setBillingAddress1(String billingAddress1) {
		this.billingAddress1 = billingAddress1;
	}
	public String getBillingAddress2() {
		return billingAddress2;
	}
	public void setBillingAddress2(String billingAddress2) {
		this.billingAddress2 = billingAddress2;
	}
	//Required
	public String getBillingCity() {
		return billingCity;
	}
	public void setBillingCity(String billingCity) {
		this.billingCity = billingCity;
	}
	//Required
	public String getBillingState() {
		return billingState;
	}
	public void setBillingState(String billingState) {
		this.billingState = billingState;
	}
	//Required
	public String getBillingPostalCode() {
		return billingPostalCode;
	}
	public void setBillingPostalCode(String billingPostalCode) {
		this.billingPostalCode = billingPostalCode;
	}
	//Required
	public String getShippingAddress1() {
		return shippingAddress1;
	}
	public void setShippingAddress1(String shippingAddress1) {
		this.shippingAddress1 = shippingAddress1;
	}
	public String getShippingAddress2() {
		return shippingAddress2;
	}
	public void setShippingAddress2(String shippingAddress2) {
		this.shippingAddress2 = shippingAddress2;
	}
	//Required
	public String getShippingCity() {
		return shippingCity;
	}
	public void setShippingCity(String shippingCity) {
		this.shippingCity = shippingCity;
	}
	//Required
	public String getShippingState() {
		return shippingState;
	}
	public void setShippingState(String shippingState) {
		this.shippingState = shippingState;
	}
	//Required
	public String getShippingPostalCode() {
		return shippigPostalCode;
	}
	public void setShippingPostalCode(String shippingPostalCode) {
		this.shippigPostalCode = shippingPostalCode;
	}
	//Required
	public String getShippingType() {
		return shippingType;
	}
	public void setShippingType(String shippingType) {
		this.shippingType = shippingType;
	}
	public DollarAmount getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(DollarAmount subTotal) {
		this.subTotal = subTotal;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public DollarAmount getShipping() {
		return shipping;
	}
	public void setShipping(DollarAmount shipping) {
		this.shipping = shipping;
	}
	public DollarAmount getTax() {
		return tax;
	}
	public void setTax(DollarAmount tax) {
		this.tax = tax;
	}
	public DollarAmount getTotal() {
		return subTotal.plus(shipping).plus(tax);
	}
	public Map<String, DollarAmount> getShippingRates() {
		return shippingRates;
	}
	public void setShippingRates(Map<String, DollarAmount> shippingRates) {
		this.shippingRates = shippingRates;
	}

}
