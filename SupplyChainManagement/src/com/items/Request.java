package com.items;
import com.model.Stock;

public class Request {

	private int id;
	private String requesterName;
	private Stock[] productList;
	private int totalQuantity;
	private double totalPrice;
	private int status;
	
	public Request(Stock[] productList) {
		id = 0;
		requesterName = "";
		this.productList = productList;
		
		totalQuantity = 0;
		for(int i = 0; i < productList.length; i++)
			totalQuantity += productList[i].getQuantity();
		
		totalPrice = 0.0;
		for(int i = 0; i < productList.length; i++)
			totalPrice += productList[i].getProduct().getPrice();
		
		status = 0;
	}
	
	public void setID(int id) {
		this.id = id;
	}
	
	public int getID() {
		return this.id;
	}
	
	public int getRequestStatus() {
		return this.status;
	}
	
	public void setRequestStatus(int status){
		this.status = status;
	}
	
	public void setRequesterName(String name) {
		requesterName = name;
	}
	
	public String getRequesterName(){
		return this.requesterName;
	}
	
	public double getTotalPrice() {
		return this.totalPrice;
	}
	
	public int getTotalQuantity() {
		return this.totalQuantity;
	}
	
	public Stock[] getProductList() {
		return this.productList;
	}
}
