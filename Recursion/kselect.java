package Recursion;

import java.util.*;

public class kselect {
	 /**
	  * 
	  * @param ustr = unique string.
	  * @param cs = current selection.
	  * @param ts = total selection.
	  * @param lc = last char
	  * @param asf = answer so far.
	  */
	
	public static void generateselect(String ustr,int cs,int ts,int lc,String asf) {
		
		if(cs > ts) {
			System.out.println(asf);
			return;
		}
		
		for(int i = lc + 1; i < ustr.length(); i++) {
			char ch = ustr.charAt(i);
			generateselect(ustr,cs + 1,ts,i,asf + ch);
		}
		
		
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int k = sc.nextInt();
		
		HashSet<Character> unique = new HashSet<>();
		String ustr = "";
		for(char ch : str.toCharArray()) {
			if(unique.contains(ch) == false) {
				unique.add(ch);
				ustr += ch;
			}
		}
		generateselect(ustr,1,k,-1,"");
	}

}
