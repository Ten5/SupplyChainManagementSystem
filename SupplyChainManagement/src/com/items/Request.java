package com.items;
import com.model.Stock;

//@invariant("id != null")

public class Request {

	private int id;
	private String requesterName;
	private Stock[] productList;
	private int totalQuantity;
	private double totalPrice;
	private int status;
	private int listSize;
	
	public Request(Stock[] productList, String name) {
		id = (int)(Math.random()*10);
		requesterName = name;
		this.productList = productList;
		
		totalQuantity = 0;
		for(int i = 0; i < productList.length; i++)
			totalQuantity += productList[i].getQuantity();
		
		totalPrice = 0.0;
		for(int i = 0; i < productList.length; i++)
			totalPrice += (productList[i].getProduct().getPrice() * productList[i].getQuantity());
		
		listSize = productList.length;
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
	
	public int getSize() {
		return this.listSize;
	}
	
	public String showProducts() {
		String list = "";
		for(Stock s : productList) {
			list += s.getProduct().getType() + " | ";
		}
		return list;
	}
}
