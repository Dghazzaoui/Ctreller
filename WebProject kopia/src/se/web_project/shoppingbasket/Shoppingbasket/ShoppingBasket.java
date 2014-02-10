package se.web_project.shoppingbasket.Shoppingbasket;

import java.util.HashMap;

public final class ShoppingBasket<Products> {

	private static final ShoppingBasket shoppingBasket = new ShoppingBasket();

	private HashMap<Integer, Products> basket;

	private ShoppingBasket() {
		basket = new HashMap<Integer, Products>();
	}

	public static ShoppingBasket getBasketInstance() {
		return shoppingBasket;
	}

	// add to cart
	public void addProduct(Products products, int amount) {
		if (!basket.containsKey(products))
			basket.put(amount, products);
		else {
			int current_amount = (Integer) basket.get(products);
			basket.put(current_amount + amount, products);
		}
	}

	// remove by quantity
	public void removeProduct(Products product, int amount) {
		if (basket.containsKey(product)) {
			int current_amount = (Integer) basket.get(product);
			if (current_amount > amount) {
				basket.put(current_amount - amount, product);
			}
		}

	}

	// remove by product type

	public void removeProductByType(Products product) {
		if (basket.containsKey(product))
			basket.remove(product);
	}

	// remove all contents

	public void clear() {
		basket.clear();
	}

	public int size() {
		return (basket.size());
	}

	public Products getAmount(Products product) {
		// returns either the quantity or weight of selected product in basket
		return basket.get(product);
	}

	public HashMap<Integer,Products> getBasket() {
		return basket;
	}
}
