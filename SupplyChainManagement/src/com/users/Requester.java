package com.users;

import com.items.Request;
import com.model.Stock;

public class Requester extends User {

	public Requester(String name, String password, String email) {
		super(name, password, email);
	}

	@Override
	public void login() {
		// TODO Auto-generated method stub
		
	}
	
	public Request createRequest(Stock[] productList) {
		Request request = new Request(productList, this.getName());
		return request;
	}
	
	public void addStock(Stock stock, int quantity) {
		stock.setStock(quantity);
	}
	
	
}
