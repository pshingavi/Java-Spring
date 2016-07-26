package com.pshingavi.spring;

import java.util.List;

public class Market {
	private FruitBasket bestFruitBaskeet;
	private List<FruitBasket> fruitBasketList;
	
	public Market(FruitBasket bestFruitBasket, List<FruitBasket> fruitBasketList) {
		this.bestFruitBaskeet = bestFruitBasket;
		this.fruitBasketList = fruitBasketList;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ALL BASKETS\n");
		for(FruitBasket basket : fruitBasketList) {
			sb.append(basket);
			sb.append("\n");
		}
		sb.append("BEST BASKET\n");
		sb.append(this.bestFruitBaskeet);
		return sb.toString();
	}
}
