package com.greatlearning.question1;

import java.util.Scanner;
import java.util.Stack;

public class BalancingBrackets {

	    // function to check if brackets are balanced
	    static boolean checkingBracketsBalanced(String bracketExpression)
	    {
	    	
	        if(bracketExpression.length() %2 != 0)
	        	return false;
	        
	    	
	        Stack<Character> stack = new Stack<Character>();
	 
	        
	        for (int i = 0; i < bracketExpression.length(); i++)
	        {
	        	
	            char readCharacter = bracketExpression.charAt(i);
	 
	            if(! "{}[]()".contains(readCharacter+"")) {
	            	return false;
	            }
	            
	            if (readCharacter == '(' || readCharacter == '[' || readCharacter == '{')
	            {
	                stack.push(readCharacter);
	                continue;
	            }
	           
	 
	            if (stack.isEmpty())
	            	return false;
	            
	            char popChar = ' ';
	            
	            switch (readCharacter) {
	            
	            case '}':
	            	
	            	popChar = stack.pop();
	                if (popChar != '{')
	                	return false;
	                break;
	                
	            case ')':
	            	
	                popChar = stack.pop();
	                if (popChar != '(' )
	                	return false;
	                break;
	 
	            case ']':
	                popChar = stack.pop();
	                if (popChar != '[')
	                    return false;
	                break;
	            }
	        }	       
	        return (stack.isEmpty());
	    }
	 
	    // Driver code
	    public static void main(String[] args)
	    {
	    	Scanner scan = new Scanner(System.in);
	    	System.out.println("Enter braces String ");
	        String bracketExpression = scan.next();
	         
	        Boolean result;
	        
	        result = checkingBracketsBalanced(bracketExpression);
	        
	        if (result)
	            System.out.println("The entered String has Balanced Brackets");
	        else
	            System.out.println("The entered Strings do not contain Balanced Brackets ");
	        
	        scan.close();
	    }
	}

