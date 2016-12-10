package com.model;

//@invariant("product != null")
//@invariant("quantity != null")

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
	
	public void setStock(int quantity) {
		this.quantity = quantity;
	}
	
	public int getQuantity() {
		return this.quantity;
	}
	
	public int deductStock(int quantity) {
		return this.quantity -= quantity;
	}
}
