package Recursion;

import java.util.HashSet;
import java.util.Scanner;

public class klengthword3 {
	
	/**
	 * 
	 * @param cs = current slot.
	 * @param ts = total slot.
	 * @param ustr = unique string.
	 * @param used = for which character is used.
	 * @param asf = answer so far.
	 */
	
	public static void generateWords(int cs,int ts,String ustr,
			HashSet<Character> used,String asf) {
		
		if(cs > ts) {
			System.out.println(asf);
			return;
		}
		
		for(int i = 0 ; i < ustr.length(); i++) {
			char ch = ustr.charAt(i);
			if(used.contains(ch) == false) {
				used.add(ch);
				generateWords(cs + 1,ts,ustr,used,asf + ch);
				used.remove(ch);
			}
		}
		
	}
	

	public static void main(String[] args) {
		
		
		  Scanner sc = new Scanner(System.in);
		  String str = sc.next();
		  int k = sc.nextInt();
		   
		 /**
		  * THIS CODE IS USED FOR TO FIND DISTINCT CHARACTER IN STRING 
		  */
		  HashSet<Character> unique = new HashSet<>();
		  String ustr = "";
		  for(char ch : str.toCharArray()) {
			  if(unique.contains(ch) == false) {
				  unique.add(ch);
				  ustr += ch;
			  }
		  }
		  generateWords(1,k,ustr,new HashSet<>(),"");
	}

}
