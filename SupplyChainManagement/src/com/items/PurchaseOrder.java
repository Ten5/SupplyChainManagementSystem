package com.items;

public class PurchaseOrder {

	private int id;
	private int status;
	private Request requestedItems;
	
	public PurchaseOrder(int id, int status, Request requestedItems) {
		this.id = 0;
		this.status = 0;
		this.requestedItems = requestedItems;
	}
	
	public void setID(int id) {
		this.id = id;
	}
	
	public int getID() {
		return this.id;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
	
	public int getStatus() {
		return this.status;
	}
	
	public Request getRequestItems() {
		return this.requestedItems;
	}
}
