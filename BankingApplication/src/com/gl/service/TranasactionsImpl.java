package com.gl.service;

import java.util.Scanner;

import com.gl.entity.Customer;
import com.gl.interfaces.Tranasaction;
import com.gl.util.OtpGenerator;

public class TranasactionsImpl implements Tranasaction {

	private Customer customer;

	public TranasactionsImpl(Customer customer) {
		super();
		this.customer = customer;
	}
	@Override
	public void deposit(int amount) {
		customer.setBalance(customer.getBalance() + amount);
		System.out.println("Current Balance : " + customer.getBalance());
	}

	@Override
	public void withdraw(int amount) {
		if(customer.getBalance() > amount) {
			customer.setBalance(customer.getBalance() - amount);
			System.out.println("Current Balance : " + customer.getBalance());
		}
		else {
			System.out.println("No sufficient balance to withdraw");
		}
	}

	@Override
	public void transfer(int amount) {
		withdraw(amount);
	}

	@Override
	public void logout() {
		System.out.println("Thank you for using our Banking system ");
		System.exit(0);
	}
}
