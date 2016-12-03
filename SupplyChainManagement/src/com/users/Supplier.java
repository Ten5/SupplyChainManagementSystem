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
	
	public void listStock(Stock product, int stock) {
		boolean flag = false;
		for(Stock s : listOfProducts) {
			if(s.getProduct().getType().compareTo(product.getProduct().getType()) == 0) {
				s.setStock(stock);
				flag = true;
			}
		}
		if(!flag)
			System.out.println("Product:" + product.getProduct().getType() + " could not be found!");
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
