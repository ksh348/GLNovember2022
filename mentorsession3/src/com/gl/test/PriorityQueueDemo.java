package com.gl.test;

import java.util.Collections;
import java.util.PriorityQueue;


public class PriorityQueueDemo {

	public static void main(String[] args) {
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		queue.add(20);
		queue.add(30);
		queue.add(25);
		queue.add(39);
		queue.add(28);
		
		while(!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
	}

}
