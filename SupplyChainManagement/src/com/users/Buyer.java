package com.users;
import com.interfaces.MakeDecision;
import com.items.Request;
import com.model.Account;
import com.model.Stock;

public class Buyer extends User implements MakeDecision {

	public Buyer(String name, String password, String email) {
		super(name, password, email);
	}

	@Override
	public void login() {
		// TODO Auto-generated method stub
		
	}
	
	public void checkRequest(Request request, Account account) {
		double price = 0;
		for(Stock s : request.getProductList()) {
			price += s.getQuantity() * s.getProduct().getPrice();
		}
		
		if(price <= account.getBalance())
			approveRequest(request);
		else
			rejectRequest(request);
	}
	
	@Override
	public void approveRequest(Request request) {
		request.setRequestStatus(1);
		System.out.println("Request " + request.getID() + " from " + request.getRequesterName() + " approved by Buyer: " + this.getID());
	}

	@Override
	public void rejectRequest(Request request) {
		request.setRequestStatus(0);
		System.out.println("Request " + request.getID() + " from " + request.getRequesterName() + " rejected by Buyer: " + this.getID());
	}
}
