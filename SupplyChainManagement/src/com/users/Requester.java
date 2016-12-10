package com.users;

import com.items.Request;
import com.model.Stock;

//@invariant("id != null")

public class Requester extends User {

	public Requester(String name, String password, String email) {
		super(name, password, email);
	}

	@Override
	public void login(String username, String password) {
		if(username.compareTo(getEmail()) == 0 && password.compareTo(getPassword()) == 0)
			System.out.println(username + " successfully logged in.");
		else
			System.out.println(username + " failed to logged in.");
	}
	
	public Request createRequest(Stock[] productList) {
		Request request = new Request(productList, this.getName());
		return request;
	}
	
	public void addStock(Stock stock, int quantity) {
		stock.setStock(quantity);
	}
	
	
}
