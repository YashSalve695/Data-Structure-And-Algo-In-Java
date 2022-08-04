package HashMaps;

import java.util.*;

public class FindAllAnagrams {
	
	public static boolean compare(HashMap<Character, Integer> pmap, 
			                      HashMap<Character, Integer> smap) {
		
		for(char sch : smap.keySet()) {
			if(pmap.getOrDefault(sch, 0) != smap.get(sch)) {
				return false;
			}
		}
		return true;
	}
	
	private static void FindAnagrams(String source, String pattern) {
		
		HashMap<Character, Integer> smap = new HashMap<>();
		HashMap<Character, Integer> pmap = new HashMap<>();
		
		for(int i = 0; i < pattern.length(); i++) {
			char ch = pattern.charAt(i);
			pmap.put(ch, pmap.getOrDefault(ch, 0) + 1);
		}
		int i = pattern.length();
		int count = 0;
		String ans = "";
		
		while(i < source.length()) {
			if(compare(pmap, smap) == true) {
				count++;
				ans += i - pattern.length() + " ";
			}
			char ch = source.charAt(i);
			smap.put(ch, smap.getOrDefault(ch, 0) - 1);
			
			char delete = source.charAt(i - pattern.length());
			 if(smap.get(delete) == 1) {
				 smap.remove(delete);
				 
			 } else {
				 
				 smap.put(delete, smap.get(delete) - 1);
				 i++;
			 }
			 
		}
		if(compare(pmap,smap) == true) {
			count++;
			ans += i - pattern.length() + " ";
		}
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String source = sc.next();
		String pattern = sc.next();
		
		FindAnagrams(source, pattern);

	}

}
