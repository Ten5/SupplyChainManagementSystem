package com.users;
import com.model.Stock;

public class Supplier extends User {

	private Stock listOfProducts[];
	
	public Supplier(String name, String password, String email, Stock[] products) {
		super(name, password, email);
		listOfProducts = products;
	}
	
	public Stock[] getListOfProducts() {
		return listOfProducts;
	}

	@Override
	public void login() {
		// TODO Auto-generated method stub
		
	}
	
	public boolean checkPO() {
		return false;
	}
	
	public void approvePO() {
		
	}
}
