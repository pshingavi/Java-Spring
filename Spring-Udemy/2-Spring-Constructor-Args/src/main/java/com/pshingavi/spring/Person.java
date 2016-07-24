package com.pshingavi.spring;

/**
 * Created by pshingavi on 7/24/2016.
 */
public class Person {
	private int id;
	private String name;
	
	public Person() {}
	
	public Person(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person id : " + this.id + ". Person name : " + this.name;
	}
}
