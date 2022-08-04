package HashMaps;

import java.util.*;

public class Wordpattern {
	
	public static boolean wordPattern(String pattern, String str) {
		
		String words[] = str.split(" ");
		
		HashMap<Character, String> map   =  new HashMap<>();
		HashMap<String, Boolean> used  =  new HashMap<>();
		
		for(int i = 0; i < str.length(); i++) {
			char ch = pattern.charAt(i);
			
			if(map.containsKey(ch) == false) {
				if(used.containsKey(words[i]) == true) {
					return false;
					
				} else {
					
					used.put(words[i], true);
					map.put(ch, words[i]);
				}
			} else {
				
				String mapwith = map.get(ch);
				if(mapwith.equals(words[i]) == false) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		String pat = sc.next();
		String s = sc.next();
		
		boolean res = wordPattern(pat, s);
		System.out.println(res);
	}
     
}
