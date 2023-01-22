package com.gl.linkedlist;
class MyLinkedList { 
	Node head;
/* Function to reverse the linked list  
//	Initialize three pointers prev as NULL, curr as head and next as NULL.
//	Iterate through the linked list. In loop, do following. 
	// Before changing next of current, 
	// store next node 
	next = curr->next
	// Now change next of current 
	// This is where actual reversing happens 
	curr->next = prev 
	// Move prev and curr one step forward 
	prev = curr 
	curr = next
*/
	Node reverse(Node node) { 
		Node prev = null; 
		Node current = node; 
		Node next = null; 
		while (current != null) { 
			next = current.next; 
			current.next = prev; 
			prev = current; 
			current = next; 
		} 
//		node = prev; 
		return prev; 
	}
// prints content of double linked list 
	void printList(Node node) { 
		while (node != null) { 
			System.out.print(node.data + " "); 
			node = node.next; 
		}
		System.out.println();
	}
// Driver Code 
	public static void main(String[] args) { 
		MyLinkedList list = new MyLinkedList();
		
		list.head = new Node(10);
		
		list.head.next = new Node(20);
		list.head.next.next = new Node(30);
		list.head.next.next.next = new Node(40);
		System.out.println("After List Creation ");
		list.printList(list.head);
		System.out.println("\nAfter Reversing ");
		list.head = list.reverse(list.head);
		list.printList(list.head);
	}
}