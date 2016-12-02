package com.users;
import com.interfaces.MakeDecision;
import com.items.Request;

public class FinancialApprover extends User implements MakeDecision {

	public FinancialApprover(String name, String password, String email) {
		super(name, password, email);
	}

	@Override
	public void login() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void approveRequest(Request request) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rejectRequest(Request request) {
		// TODO Auto-generated method stub
		
	}
}
