package com.gl.interfaces;

public interface Tranasaction {
	void deposit(int amount);
	void withdraw(int amount);
	void transfer(int amount);
	void logout();
}