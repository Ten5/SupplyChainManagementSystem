package com.users;
import com.interfaces.MakeDecision;

public class Buyer extends User implements MakeDecision {

	public Buyer(String name, String password, String email) {
		super(name, password, email);
	}
	//Hi I have added a comment
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
