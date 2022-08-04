
//1. Given a string s, remove duplicate letters so that every letter appears once and only once.
//2. You must make sure your result is the first in dictionary order among all possible results

 /** FOR EXAMPLE ---> bcabc
                       abc **/
  
package StacksAndQueues2;

import java.util.*;
import java.io.*;

public class RemoveDuplicates {

	 public static String removeDuplicateLetters(String s) {
            
		 Stack<Character> st = new Stack<>();
		 
		 int freq[] = new int[26];
		 boolean exists[] = new boolean[26];
		 
		 for(int i = 0; i < s.length(); i++) {
			 char ch = s.charAt(i);
			 
			 freq[ch - 'a']++;// To keep count of every character.
		 }
		 for(int i = 0; i < s.length(); i++) {
			 char ch = s.charAt(i);
			 freq[ch - 'a']--;
			 
			 if(exists[ch - 'a']) continue;
			 
			 while(st.size() > 0 && st.peek() > ch && freq[st.peek() - 'a'] > 0) {
				 char remove = st.pop();
				 
				 exists[remove - 'a'] = false;
			 }
			 st.push(ch); exists[ch - 'a'] = true;
		 }
            char ans[] = new char[st.size()];
             int i = ans.length - 1;
              while(i >= 0) ans[i--] = st.pop();
              
              return new String(ans);
	    }

	    public static void main(String[] args) throws Exception {
	        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

	        String result = removeDuplicateLetters(read.readLine());
	        System.out.println(result);
	        
	    }
}
