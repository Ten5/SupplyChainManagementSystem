package com.model;

public class Stock {

	private Product product;
	private int quantity;
	
	public Stock(Product product) {
		this.product = product;
		quantity = 0;
	}
	
	public Product getProduct() {
		return this.product;
	}
	
	public void addStock(int quantity) {
		this.quantity = quantity;
	}
	
	public int getQuantity() {
		return this.quantity;
	}
	
	public int deductStock(int quantity) {
		return this.quantity -= quantity;
	}
}
