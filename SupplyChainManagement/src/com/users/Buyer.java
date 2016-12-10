package com.users;
import com.interfaces.MakeDecision;
import com.items.Request;
import com.model.Stock;

//@invariant("id != null")
public class Buyer extends User implements MakeDecision {

	public Buyer(String name, String password, String email) {
		super(name, password, email);
	}

	@Override
	public void login(String username, String password) {
		if(username.compareTo(getEmail()) == 0 && password.compareTo(getPassword()) == 0)
			System.out.println(username + " successfully logged in.");
		else
			System.out.println(username + " failed to logged in.");
	}
	
	public void checkRequest(Request request) {
		double qty = 0;
		for(Stock s : request.getProductList()) {
			qty += s.getQuantity();
		}
		
		if(qty <= 10)
			approveRequest(request);
		else
			rejectRequest(request);
	}
	//@requires (request.getRequestedStatus() = 0)
	//@ensures (request.getRequestedStatus() = 1)
	@Override
	public void approveRequest(Request request) {
		request.setRequestStatus(1);
		System.out.println("Request " + request.getID() + " from " + request.getRequesterName() + " approved by Buyer: " + this.getName());
	}
	
	//@requires (request.getRequestedStatus() = 0)
	//@ensures (request.getRequestedStatus() = 0)
	@Override
	public void rejectRequest(Request request) {
		request.setRequestStatus(0);
		System.out.println("Request " + request.getID() + " from " + request.getRequesterName() + " rejected by Buyer: " + this.getName() + " due to quantity greater than 10");
	}
}
