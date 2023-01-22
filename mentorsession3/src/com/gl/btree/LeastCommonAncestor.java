package com.gl.btree;

import java.util.ArrayList;
import java.util.List;

public class LeastCommonAncestor {
	Node root; 
	private List<Integer> path1 = new ArrayList<>(); 
	private List<Integer> path2 = new ArrayList<>(); 
	
	// Finds the path from root node to given root of the tree. 
	int findLCA(int node1, int node2) { 
		path1.clear(); 
		path2.clear(); 
		return checkingLowestCommonAncestor(root, node1, node2); 
	} 
	private int checkingLowestCommonAncestor(Node root, int node1, int node2) { 
		if (!findPath(root, node1, path1) || !findPath(root, node2, path2)) { 
//			System.out.println((path1.size() > 0) ? "node1 is present" : "node1 is missing"); 
//			System.out.println((path2.size() > 0) ? "node2 is present" : "node2 is missing"); 
			return -1; 
		} 
		int index; 
		for (index = 0; index < path1.size() && index < path2.size(); index++) { 
			// System.out.println(path1.get(i) + " " + path2.get(i)); 
			if (!path1.get(index).equals(path2.get(index))) 
				break; 
		} 
		return path1.get(index-1); 
	} 
	// Finds the path from root node to given root of the tree, Stores the 
	// path in a vector path[], returns true if path exists otherwise false 
	private boolean findPath(Node root, int n, List<Integer> path) { 
		// base case 
		if (root == null) {
			return false; 
		} 
		// Store this node . The node will be removed if // not in path from root to n. 
		path.add(root.data); 
		if (root.data == n) { 
			return true; 
		} 
		if (root.left != null && findPath(root.left, n, path)) { 
			return true; 
		} 
		if (root.right != null && findPath(root.right, n, path)) { 
			return true; 
		} 
		// If not present in subtree rooted with root, remove root from 
		// path[] and return false 
		path.remove(path.size()-1); 
		return false; 
	} 
	// Driver code 
	public static void main(String[] args) { 
		LeastCommonAncestor tree = new LeastCommonAncestor(); 
		tree.root = new Node(10); 
		tree.root.left = new Node(20); 
		tree.root.right = new Node(30); 
		tree.root.left.left = new Node(40); 
		tree.root.left.right = new Node(50); 
		tree.root.right.left = new Node(60); 
		tree.root.right.right = new Node(70); 
		int rtnValue = tree.findLCA(20,30);
		if(rtnValue != -1)
			System.out.println("Least Common Ancestor(20, 30): " + rtnValue);
		else
			System.out.println("20 or 30 - Element not found to check LCA  ");
		rtnValue = tree.findLCA(40,30);
		if(rtnValue != -1)
			System.out.println("Least Common Ancestor(40, 30): " + rtnValue);
		else
			System.out.println("40 or 30 - Element not found to check LCA  ");
		rtnValue = tree.findLCA(60,70);
		if(rtnValue != -1)
			System.out.println("Least Common Ancestor(60, 70): " + rtnValue);
		else
			System.out.println("60 or 70 - Element not found to check LCA  ");
		rtnValue = tree.findLCA(20,40);
		if(rtnValue != -1)
			System.out.println("Least Common Ancestor(20, 40): " + rtnValue);
		else
			System.out.println("20 or 40 - Element not found to check LCA  ");
		
		rtnValue = tree.findLCA(25,40);
		if(rtnValue != -1)
			System.out.println("Least Common Ancestor(25, 40): " + rtnValue);
		else
			System.out.println("25 or 40 - Element not found to check LCA  ");
	} 
}