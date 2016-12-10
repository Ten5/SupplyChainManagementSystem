package com.model;

//@invariant("id.balance != null")

public class Account {

	private int id;
	private double balance;
	
	public Account(int id) {
		this.id = id;
		balance = 0;
	}
	
	public int getID() {
		return this.id;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public double getBalance() {
		return this.balance;
	}
}
