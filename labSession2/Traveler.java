package com.greatlearning.labSession2;

import java.util.Scanner;

public class Traveler {

	public static void main(String[] args) {

		MergeSortImplementation mergeSortImplementation = new MergeSortImplementation();

		System.out.println("enter the size of currency denominations ");
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		int[] notes = new int[size];
		System.out.println("enter the currency denominations value");
		for (int i = 0; i < size; i++) {
			notes[i] = scan.nextInt();
			if(notes[i] <= 0) {
				System.out.println("Note cannot be Zero or less, please enter valid Note(s) ");
				i--;
			}
		}
		System.out.println("enter the amount you want to pay");
		int amount = scan.nextInt();
		mergeSortImplementation.sort(notes,0,notes.length-1);
		notesCountImplementation(notes, amount);
	
		scan.close();
	}
	
	private static void notesCountImplementation(int notes[], int amount) {

		int[] noteCounter = new int[notes.length];
		// notes = 10, 52, 89 ,1
		// notes = 89, 52, 10, 1 sorting in the decreasing order
		//900
		//notes 900/89 = 10 89:10
		//amount = 900-890=10
		//10/10 = 1
		//0
		
		
			for (int i = 0; i < notes.length; i++) {
				if (amount >= notes[i]) {
					noteCounter[i] = amount / notes[i];
					amount = amount % notes[i];
//					amount = amount - noteCounter[i] * notes[i];
				}
			}
			if (amount > 0) {
				System.out.println("exact amount cannot be given with the highest denomination");
			} else {
				System.out.println("Your payment approach in order to give min no of notes will be");
				for (int i = 0; i < notes.length; i++) {
					if (noteCounter[i] != 0) {
						System.out.println(notes[i] + ":" + noteCounter[i]);
					}
				}
			}
		
	}
}
