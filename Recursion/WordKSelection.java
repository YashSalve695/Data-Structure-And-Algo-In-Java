package Recursion;

import java.util.HashSet;
import java.util.Scanner;

public class WordKSelection {
	
	public static void selectK(int i, String ustr,int ssf,int ts,String asf) {
	
		if(i == ustr.length()) {
			if(ssf == ts) {
				System.out.print(asf);
			}
			return;
		}
		char ch = ustr.charAt(i);
		selectK(i + 1,ustr,ssf + 1,ts,asf + ch);
		selectK(i + 1,ustr,ssf + 0,ts,asf + "");
		
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int k = sc.nextInt();
		
		HashSet<Character> unique = new HashSet<>();
          String ustr = "";
          
          for(char ch:ustr.toCharArray()) {
        	  if(unique.contains(ch) == false) {
        		  unique.add(ch);
        		  ustr += ch;
        	  }
          }
          selectK(0,ustr,0,k,"");
	}

}
