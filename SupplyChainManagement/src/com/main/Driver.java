package com.main;

import com.items.Request;
import com.model.Account;
import com.model.Product;
import com.model.Stock;
import com.users.Buyer;
import com.users.Requester;
import com.users.Supplier;

public class Driver {

	public static void main(String[] args) {
		
		Product chair = new Product(11, "chair", 5.5);
		Stock chairStock = new Stock(chair);
		
		Product table = new Product(21, "table", 7);
		Stock tableStock = new Stock(table);
		
		Product wadrobe = new Product(15, "wardrobe", 15);
		Stock wardrobeStock = new Stock(wadrobe);
		
		Account IMABank = new Account(452);
		IMABank.setBalance(15240);
		
		Requester john = new Requester("John", "john123", "john@xxx.com");
		Buyer stan = new Buyer("Stan", "stan11", "stan@xxx.com");
		
		Stock woodStocks[] = {chairStock, tableStock, wardrobeStock};
		Supplier newWodworks = new Supplier("New Woodworks", "woodworks", "admin@woodworks.com", woodStocks);
		newWodworks.setStock(tableStock, 10);
		newWodworks.setStock(chairStock, 35);
		newWodworks.setStock(wardrobeStock, 5);
		
		Stock chairsRequired = new Stock(chair);
		chairsRequired.addStock(4);
		Stock tablesRequired = new Stock(table);
		tablesRequired.addStock(1);
		Stock customerProductList[] = {chairsRequired, tablesRequired};
		Request customerRequest = john.createRequest(customerProductList);
		customerRequest.setRequesterName(john.getName());
		
		stan.checkRequest(customerRequest, IMABank);
		
		System.out.println("Current Request Status: " + 
							"\nRequest ID: " +customerRequest.getID() + 
							"\nRequester: " + customerRequest.getRequesterName() + 
							"\nStatus: " + customerRequest.getRequestStatus());
	}
}
