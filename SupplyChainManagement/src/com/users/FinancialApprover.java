package com.users;
import com.interfaces.MakeDecision;

public class FinancialApprover extends User implements MakeDecision {

	public FinancialApprover(String name, String password, String email) {
		super(name, password, email);
	}

	@Override
	public void login() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void approveRequest() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rejectRequest() {
		// TODO Auto-generated method stub
		
	}
}