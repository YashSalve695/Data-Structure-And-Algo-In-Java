package StacksAndQueues2;

import java.util.*;
import java.io.*;

public class ReverseSubstringBtwEachPairOfParentheses {

	public static String reverseParentheses(String s) {
		
		Queue<Character> q = new LinkedList<>();
        Stack<Character> st = new Stack<>();
        
        for(int i = 0; i < s.length(); i++) {
        	if(s.charAt(i) == '')
        }
        
	}    
    
    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        String result = reverseParentheses(read.readLine());
        System.out.println(result);
        
    }
}
