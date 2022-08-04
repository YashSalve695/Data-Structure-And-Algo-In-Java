package Strings;

import java.util.*;

public class PartitionLabels {

	 public static List<Integer> partitionLabels(String s) {
		   
		 // Create hashmap to store the index of last character.
		  HashMap<Character,Integer> map = new HashMap<>();
		      for(int i = 0; i < s.length(); i++) {
		    	  char ch = s.charAt(i);
		    	   map.put(ch, i);
		      }
		// In which we have to store the result.     
		       List<Integer> res = new ArrayList<>();
		        int prev = -1;
		        int max = 0;
		
	   // iterate through the given string 	        
		        for(int i = 0; i < s.length(); i++) {
		        	char ch = s.charAt(i);
	   // see at which index the last character is present. 	        	
		        	max = Math.max(max, map.get(ch));
	   // see at which max index the character is present.        	
		        	 if(max == i) {
	   // when we reached at that max postion of that character
	   // add in result,subtract it by max and prev.	        		 
		        		 res.add(max - prev);
		        		 prev = max;
	   // And update that max to prev.	        		 
		        	 }
		        }
		        return res;
	   // And return the result.	        
		  }

		 
		  public static void main(String[] args) {
		    Scanner scn = new Scanner(System.in);
		    String str = scn.nextLine();

		    List<Integer> res = partitionLabels(str);
		    for (int val : res) {
		      System.out.print(val + " ");
		    }
		  }
		}
