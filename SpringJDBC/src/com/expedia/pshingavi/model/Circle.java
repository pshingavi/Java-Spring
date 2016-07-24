package com.expedia.pshingavi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="circle")
public class Circle {

	@Column(name="ID")
	@Id
	private int id;
	
	@Column(name="NAME")
	private String name;
	
	public Circle(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public Circle() {
		// TODO Auto-generated constructor stub
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
	
}
