package com.users;

public abstract class User {

	private long id;
	private String name;
	private String password;
	private String email;
	
	public User(String name, String password, String email) {
		id = Math.round(Math.random()*1000);
		this.name = name;
		this.password = password;
		this.email = email;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public long getID() {
		return this.id;
	}
	
	abstract public void login();
}
