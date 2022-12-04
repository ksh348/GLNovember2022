package com.gl.service;

import com.gl.interfaces.Credentials;

import java.util.Random;

import com.gl.entities.Employee;

public class CredentialService implements Credentials {

	@Override
	public String generatePassword() {
		String caps = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String small = "abcdefghijklmnopqrstuvwxyz";
		String nums = "1234567890";
		String special = "!@#$%^&*><:.,";
		
//		Approach 1
//		values = caps + small + nums + special;
//		password += String.valueOf(values.charAt(random.nextInt(values.length())));
		
//		Approach 2
//		temp = (char) (random.nextInt(126 - 33) + 33); 
//		password += temp;
		StringBuffer passwd = new StringBuffer();
		Random random = new Random();
		int rand = random.nextInt(caps.length());
		passwd.append(caps.charAt(rand));
		
		rand = random.nextInt(small.length());
		passwd.append(small.charAt(rand));
		
		rand = random.nextInt(special.length());
		passwd.append(special.charAt(rand));

		rand = random.nextInt(nums.length());
		passwd.append(nums.charAt(rand));

		for(int index=0; index<6; index++) {
			rand = random.nextInt(4);
			
			switch (rand) {
			case 0:
				rand = random.nextInt(caps.length());
				passwd.append(caps.charAt(rand));
				break;
			case 1:
				rand = random.nextInt(small.length());
				passwd.append(small.charAt(rand));
				break;
			case 2:
				rand = random.nextInt(special.length());
				passwd.append(special.charAt(rand));
			case 3:
				rand = random.nextInt(nums.length());
				passwd.append(nums.charAt(rand));

			}
		}
		
		return passwd.toString();
	}

	@Override
	public String generateEmailAddress(String firstName, String lastName, String department) {
		return firstName.toLowerCase() + lastName.toLowerCase() + "@" + department + ".greatlearning.com";
	}

	@Override
	public void showCredentials(Employee emp) {
		System.out.println(emp);
	}

}
