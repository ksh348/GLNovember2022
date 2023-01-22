package com.gl.test;

import java.util.Comparator;

public class ComparatorDemo {
	
	class Employee {
		private int eno;
		private String ename;
		private double sal;
	}
	class Demo implements Comparator<Employee>{

		@Override
		public int compare(Employee obj1, Employee obj2) {

			return obj1.ename.compareTo(obj2.ename);
		}
		
	}
	
	public static void main(String[] args) {
		
	}
}