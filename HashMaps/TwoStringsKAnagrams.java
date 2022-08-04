package HashMaps;

import java.util.*;

 /** 1. You are given two strings s1, s2, and a number K.
     2. You have to find if two strings are K-anagrams of each other or not.
     3. Two strings are called K-anagrams if 
        -> Both s1 and s2 have the same number of characters.
        -> After changing K characters in any string, s1 and s2 become anagram of each other. 

     Note -> Both s1 ad s2 consist of lowercase English letters only. */

public class TwoStringsKAnagrams {
	
	public static boolean kAnagrams(String s1, String s2, int k) {
		
		if(s1.length() != s2.length()) {
			return false;
		}
		HashMap<Character, Integer> map = new HashMap<>();
		 for(int i = 0; i < s1.length(); i++) {
			 char ch = s1.charAt(i);
			 map.put(ch, map.getOrDefault(ch, 0) + 1);
		 }
		 for(int i = 0; i < s2.length(); i++) {
			 char ch = s2.charAt(i);
			 if(map.getOrDefault(ch, 0) > 0) {
				 map.put(ch, map.getOrDefault(ch, 0) - 1);
			 }
		 }
		 int count = 0;
		 for(char ch : map.keySet()) {
			 count += map.get(ch);
		 }
		 if(count > k) {
			 return false;
		 } else {
			 return true;
		 }
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();
		int k = sc.nextInt();
		
		boolean res = kAnagrams(s1, s2, k);
		 System.out.println(res);

	}

}
