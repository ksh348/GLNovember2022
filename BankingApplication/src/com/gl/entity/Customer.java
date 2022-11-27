package com.gl.entity;

public class Customer {
	private long accountNumber;
	private String password;
	private double balance;
	
	public Customer() {
		super();
	}
	public Customer(long accountNumber, String password, double balance) {
		super();
		this.accountNumber = accountNumber;
		this.password = password;
		this.balance = balance;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
}