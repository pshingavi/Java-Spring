package com.pshingavi.spring.factory;

import com.pshingavi.spring.Person;

public class PersonFactory {
	public Person createPerson(int id, String name) {
		System.out.println("Using factory to create Person !");
		return new Person(id, name);
	}
}
