package com.gl.app;

import java.util.Scanner;

import com.gl.entity.Customer;
import com.gl.interfaces.Tranasaction;
import com.gl.service.TranasactionsImpl;
import com.gl.util.OtpGenerator;

public class BankingApp {
	public static void main(String[] args) {
		Customer customer = new Customer(1234567, "glbank", 2000);
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your account Number : ");
		long accountNumber = scanner.nextLong();
		System.out.println("Enter your password : ");
		String password = scanner.next();
		if(accountNumber == customer.getAccountNumber() &&
				password.equals(customer.getPassword())) {
			Tranasaction tranaction = new TranasactionsImpl(customer);
			int option = 0;
			do {
				System.out.println("1. Deposit ");
				System.out.println("2. Withdraw ");
				System.out.println("3. Transfer ");
				System.out.println("4. Logout ");
				System.out.println("Enter your option ");
				option = scanner.nextInt();
				int amount = 0;
				long tranAccountNumber = 0;
				switch (option) {
				case 1:
					System.out.println("Enter the amount to deposit");
					amount = scanner.nextInt();
					tranaction.deposit(amount);
					break;
				case 2:
					System.out.println("Enter the amount to withdraw");
					amount = scanner.nextInt();
					tranaction.withdraw(amount);
					break;
				case 3:
					System.out.println("Enter the account number to transfer");
					tranAccountNumber = scanner.nextLong();
					System.out.println("Enter the amount to transfer");
					amount = scanner.nextInt();
					//		OtpGenerator optObject = new OtpGenerator();
					//		int otp = optObject.getOTP();
					int otp = new OtpGenerator().getOTP();
					System.out.println("System Generated is OTP : " + otp);
					System.out.println("Enter OTP : ");
					int userOtp = scanner.nextInt();
					if(otp == userOtp)
					{
						tranaction.transfer(amount);
					}
					else {
						System.out.println("Invalid OTP Transaction cannot be completed");
					}
					break;
				case 4:
					scanner.close();
					tranaction.logout();
					break;
				default:
					System.out.println("Invalid Option please retry ");
				}
			}while(option != 4);
		}
		else {
			System.out.println("Sorry Invalid User or Password ");
		}
	}
}