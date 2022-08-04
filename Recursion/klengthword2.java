package Recursion;

import java.util.*;

public class klengthword2 {
       /**
        * 	
        * @param cc = current character.
        * @param ustr = unique string.
        * @param ssf = select so far.
        * @param ts = total selection.
        * @param spots = k spots.
        */
	  public static void generatewords(int cc,String ustr,int ssf,int ts,
			                             Character[]spots) {
		  
		  if(cc == ustr.length()) {
			  if(ssf == ts) {
				  for(int i = 0; i < spots.length; i++) {
					  System.out.print(spots[i]);
				  }
                   System.out.println();
			  }
			  return;
		  }
		  char ch = ustr.charAt(cc);
		  for(int i = 0; i < spots.length; i++) {
			  if(spots[i] == null) {
				  spots[i] = ch;
				  generatewords(cc + 1,ustr,ssf + 1,ts,spots);
				  spots[i] = null;
			  }
		  }
		  generatewords(cc + 1,ustr,ssf + 0,ts,spots);
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
		  Character[] spots = new Character[k];
		  generatewords(0,ustr,0,k,spots);
	}

}
