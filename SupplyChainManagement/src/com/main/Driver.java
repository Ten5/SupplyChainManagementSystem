package com.main;

import com.items.PurchaseOrder;
import com.items.Request;
import com.model.Account;
import com.model.Product;
import com.model.Stock;
import com.users.Buyer;
import com.users.FinancialApprover;
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
			
		Account IMABank = new Account(4520);
		IMABank.setBalance(50);
		
		Account MTBank = new Account(4500);
		MTBank.setBalance(40);
		
		Account[] accounts = {IMABank, MTBank};
		
		Requester john = new Requester("John", "john123", "john@xxx.com");
		Requester shad = new Requester("Shad", "shad123", "shad@xyz.com");
		Buyer stan = new Buyer("Stan", "stan11", "stan@xxx.com");
		FinancialApprover ravi = new FinancialApprover("Ravi", "ravi12", "ravi@xyz.com");
		
		john.login("john@xxx.com", "john123");
		shad.login("shad@xyz.com", "shad12");
		shad.login("shad@xyz.com", "shad123");
		stan.login("stan@xxx.com", "stan11");
		ravi.login("ravi@xyz.com", "ravi12");
		
		System.out.println();
		
		Stock woodStocks[] = {chairStock, tableStock, wardrobeStock};
		Supplier newWodworks = new Supplier("New Woodworks", "woodworks", "admin@woodworks.com", woodStocks);
		newWodworks.listStock(tableStock, 6);
		newWodworks.listStock(chairStock, 13);
		newWodworks.listStock(wardrobeStock, 5);
		
		Stock chairsRequiredJohn = new Stock(chair);
		Stock chairsRequiredShad = new Stock(chair);
		
		john.addStock(chairsRequiredJohn, 6);
		shad.addStock(chairsRequiredShad, 4);
		
		Stock tablesRequiredJohn = new Stock(table);
		Stock tablesRequiredShad = new Stock(table);
		
		john.addStock(tablesRequiredJohn, 1);
		shad.addStock(tablesRequiredShad, 3);
		
		Stock johnProductList[] = {chairsRequiredJohn, tablesRequiredJohn};				
		Request johnRequest = john.createRequest(johnProductList);
		
		Stock shadProductList[] = {chairsRequiredShad, tablesRequiredShad};				
		Request shadRequest = shad.createRequest(shadProductList);
		
		print(johnRequest);
		print(shadRequest);
		
		stan.checkRequest(johnRequest);
		PurchaseOrder PO1 = ravi.checkRequest(johnRequest, accounts);
		if(PO1 != null)
		newWodworks.checkPO(PO1);
		
		stan.checkRequest(shadRequest);
		PurchaseOrder PO2 = ravi.checkRequest(shadRequest, accounts);
		if(PO2 != null)
		newWodworks.checkPO(PO2);
		
		print(johnRequest);
		print(shadRequest);
	}
	
	public static void print(Request customerRequest) {
		System.out.println("Requester: "+ customerRequest.getRequesterName() +"\n---Current Request Status--- " + 
				"\nRequest ID: " +customerRequest.getID() + 
				"\nRequester: " + customerRequest.getRequesterName() +
				"\nItems: " + customerRequest.showProducts() +
				"\nSize of List: " + customerRequest.getSize() +
				"\nTotal Price: " + customerRequest.getTotalPrice() +
				"\nTotal Quantity: " + customerRequest.getTotalQuantity() +
				"\nStatus: " + customerRequest.getRequestStatus() + "\n"); 
	}
}
