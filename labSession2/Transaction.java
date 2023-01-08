package com.greatlearning.labSession2;

import java.util.Scanner;

class Transaction {

	public static void main(String args[])  {

		Scanner scan = new Scanner(System.in);
		
		System.out.println("enter the size of transaction array");

		int size = scan.nextInt();

		int transArr[] = new int[size];

		System.out.println("enter the values of array");
		
		for (int i = 0; i < transArr.length; i++)
			transArr[i] = scan.nextInt();

		System.out.println("enter the total no of targets that needs to be achieved");
		int targetNo = scan.nextInt();

		while (targetNo-- > 0) {
			boolean acheived = false;
			long target;
			System.out.println("enter the value of target");
			target = scan.nextLong();

			long sum = 0;

			for (int i = 0; i < size; i++) { //linear iteration , linear searching
				sum += transArr[i];
				if (sum >= target) {
					System.out.println("Target achieved after "+(i + 1) + " transactions ");
					acheived = true;
					break;
				}
			}

			if (!acheived) {
				System.out.println(" Given target is not achieved ");
			}
		}
		scan.close();
	}

}
