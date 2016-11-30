package com.model;

public class Product {

	private int id;
	private String type;
	private double price;
	private Stock stock;
	
	public Product() {
		id = 0;
		type = "";
		price = 0.0;
		stock = new Stock(this);
	}
	
	public void setID(int id) {
		this.id = id;
	}
	
	public int getID() {
		return this.id;
	}
	
	public void setType(String type) {
		this.type = type;  
	}
	
	public String getType() {
		return type;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public int getStock() {
		return this.stock.getQuantity();
	}
}
