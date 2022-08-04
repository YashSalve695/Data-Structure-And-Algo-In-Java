package Recursion;

import java.util.Scanner;

public class PrintAbbreviation {
	
	public static void abbrevate(String str,String asf,int count
			                                      ,int position) {
		
		if(position == str.length()) {
			if(count == 0) {
				System.out.println(asf);
			} else {
				System.out.println(asf + count);
			}
					 return;
				
		}
		if(count > 0) {
			abbrevate(str,asf + count + str.charAt(position),0,
					position + 1);
		} else {
			abbrevate(str,asf + str.charAt(position),0,
					position + 1);
			abbrevate(str,asf,count + 1,position + 1);
		}
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		abbrevate(str,"",0,0);

	}

}
