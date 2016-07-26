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
		System.out.println("In constructor !");
		this.id = id;
		this.name = name;
	}
	
	// see bean factory-method
	public static Person getPersonInstance(int id, String name) {
		System.out.println("Creating Person using factory-method");
		return new Person(id, name);
	}
	
	public void onCreateMethod() {
		System.out.println("Person created !");
	}
	
	public void onDestroyMethod() {
		System.out.println("Person destroyed !");
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
