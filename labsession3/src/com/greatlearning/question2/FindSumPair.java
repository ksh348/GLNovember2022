package com.greatlearning.question2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Node {
	int nodeData;
	Node leftNode;
	Node rightNode;
	Node(int nodeData)
	{
		this.nodeData = nodeData;
		this.leftNode = null;
		this.rightNode = null;
	}
}

class FindSumPair {

	public Node insert(Node currentLocation, int key)
	{
		if (currentLocation == null)
			return new Node(key);
		
		if (key < currentLocation.nodeData)
			currentLocation.leftNode = insert(currentLocation.leftNode, key);
		else
			currentLocation.rightNode = insert(currentLocation.rightNode, key);
		return currentLocation;
	}

	public boolean findpairUtil(Node currentLocation, int sum,
			List<Integer> list)
	{
		if (currentLocation == null)
			return false;

		if (findpairUtil(currentLocation.leftNode, sum, list))
			return true;

		if (list.contains(sum - currentLocation.nodeData)) {
			System.out.println("Pair is found ("
					+ (sum - currentLocation.nodeData) + ", "
					+ currentLocation.nodeData + ")");
			return true;
		}
		else
			list.add(currentLocation.nodeData);

		return findpairUtil(currentLocation.rightNode, sum, list);
	}

	// Driver code
	public static void main(String[] args)
	{
		Node root = null;	
		FindSumPair findSP = new FindSumPair();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Tree value to STOP enter -1 ");
		int data = 0;
		do {
			data = scan.nextInt();
			if(data != -1)
				root = findSP.insert(root, data);
//		root = findSP.insert(root, 40);
//		root = findSP.insert(root, 20);
//		root = findSP.insert(root, 60);
//		root = findSP.insert(root, 10);
//		root = findSP.insert(root, 30);
//		root = findSP.insert(root, 50);
//		root = findSP.insert(root, 70);
		}while(data != -1);
		System.out.println("Enter the Sum value to find the pair ");
		int sum = scan.nextInt();
		List<Integer> list = new ArrayList<>();
		if (!findSP.findpairUtil(root, sum, list))
			System.out.println("Pairs do not exit");
		
		scan.close();
	}
}