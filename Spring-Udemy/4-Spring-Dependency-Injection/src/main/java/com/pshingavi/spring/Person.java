package com.pshingavi.spring;

/**
 * Created by pshingavi on 7/24/2016.
 */
public class Person {
	private int id;
	private String name;
	
	private int taxId;
	private Address address;
	
	public Person() {}
	
	public Person(int id, String name) {
		this.id = id;
		this.name = name;
	}
	

	public void setTaxId(int taxId) {
		this.taxId = taxId;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Person id : " + this.id + ". Person name : " + this.name + ". Person  taxId : " + this.taxId + " " + this.address;
	}

}
