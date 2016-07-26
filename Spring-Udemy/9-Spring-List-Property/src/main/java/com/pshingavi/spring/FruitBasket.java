package com.pshingavi.spring;

import java.util.List;

public class FruitBasket {
	private String name;
	private List<String> fruitsList;
	
	public FruitBasket(String name, List<String> fruitsList) {
		this.name = name;
		this.fruitsList = fruitsList;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Basket name : " + this.name);
		for(String fruit : fruitsList) {
			sb.append(fruit);
			sb.append("\n");
		}
		return sb.toString();
	}
}
