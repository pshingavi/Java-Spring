package com.pshingavi.spring;

public class Address {
	private String street;
	private int postcode;
	
	public Address() {}
	
	public Address(String street, int postcode) {
		this.street = street;
		this.postcode = postcode;
	}
	
	// Runs global init-method
	public void onCreateMethod() {
		System.out.println("Address created !");
	}
	
	public void onDestroyMethod() {
		System.out.println("Address destroyed !");
	}
	
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getPostcode() {
		return postcode;
	}

	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}

	@Override
	public String toString() {
		return "Address [Street= " + this.street + ", Postcode= " + this.postcode + "]";
	}
}
