package Recursion;

import java.util.*;

public class CrytarithmeticPuzzle {
	
public static int getNum(String s,HashMap<Character,Integer> charIntmap) {
		
		String num = "";
		for(int i = 0; i < s.length(); i++) {
			num += charIntmap.get(s.charAt(i));
		}
		return Integer.parseInt(num);
	}
	
	public static void solution(String unique,int indx,
			HashMap<Character,Integer> charIntmap,boolean []usedNumbers,
			String s1,String s2,String s3) {
		
		if(indx == unique.length()) {
			int num1 = getNum(s1,charIntmap);
			int num2 = getNum(s2,charIntmap);
			int num3 = getNum(s3,charIntmap);
			
			if(num1 + num2 == num3) {
				for(int i = 0; i < 26; i++) {
					char ch = (char)('a' + i);
					if(charIntmap.containsKey(ch)) {
						System.out.print(ch + "-" + charIntmap.get(ch) + " ");
					}
				}
				System.out.println();
			}
			return;
			
		}
		
		char ch = unique.charAt(indx);
		for(int num = 0; num <= 9; num++) {
			if(usedNumbers[num] == false) {
		//Because if number is not assigned.
				charIntmap.put(ch, num);
		//Then put a number from "0" to "9" to that char.		
				usedNumbers[num] = true;
		//Then make it true after assigning the number to that character.		
				solution(unique,indx + 1,charIntmap,usedNumbers,s1,s2,s3);
		//Then add the words using RECURSION.		
				usedNumbers[num] = false; // BACKTRACK
		//And make that next word false.And make that character -1. 		
				charIntmap.put(ch,-1);
			}
		}
	}
	
	

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		String s3 = sc.nextLine();
		
		// HASHMAP IS USED FOR TO KNOW THE DISTINCT CHARACTER IN WOEDS.
		HashMap<Character,Integer> charIntmap = new HashMap<>();
		 String unique = "";
		 for(int i = 0; i < s1.length(); i++) {
			if(!charIntmap.containsKey(s1.charAt(i))) {
				 charIntmap.put(s1.charAt(i),-1);
				 unique += s1.charAt(i);
			 }
		 }
		 for(int i = 0; i < s2.length(); i++) {
				if(!charIntmap.containsKey(s2.charAt(i))) {
					 charIntmap.put(s2.charAt(i),-1);
					 unique += s2.charAt(i);
				 }
			 }
		 for(int i = 0; i < s3.length(); i++) {
				if(!charIntmap.containsKey(s3.charAt(i))) {
					 charIntmap.put(s3.charAt(i),-1);
					 unique += s3.charAt(i);
				 }
			 }
		boolean []usedNumbers = new boolean[10];
		solution(unique,0,charIntmap,usedNumbers,s1,s2,s3);
	}

}
