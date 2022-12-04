package com.gl.interfaces;

import com.gl.entities.Employee;

public interface Credentials {
	String generatePassword();
	String generateEmailAddress(String firstName, String lastName, String department);
	void showCredentials(Employee emp);
}