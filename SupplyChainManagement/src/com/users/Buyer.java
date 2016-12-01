package com.users;
import com.interfaces.MakeDecision;
import com.items.Request;

public class Buyer extends User implements MakeDecision {

	public Buyer(String name, String password, String email) {
		super(name, password, email);
	}

	@Override
	public void login() {
		// TODO Auto-generated method stub
		
	}
	
	public void approveRequest(Request request) {
		request.setRequestedStatus(1);
	}

	@Override
	public void rejectRequest(Request request) {
		// TODO Auto-generated method stub
		request.setRequestedStatus(-1);
	}
}
