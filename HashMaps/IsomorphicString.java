package HashMaps;

import java.util.*;

public class IsomorphicString {
	
	private static boolean Isomorphic(String str, String target) {
		
		if(str.length() != target.length()) {
			return false;
		}
		
		HashMap<Character, Character> map1 = new HashMap<>();
		/** This map will use to map char in string
		     and char in target */
		
		HashMap<Character, Boolean> map2 = new HashMap<>();
		/** This map will store the char in target string if it is already
		     map will char present in string or not ,ṁ*/
		
		for(int i = 0; i < str.length(); i++) {
			char chstr = str.charAt(i);
			char chtarget = target.charAt(i);
			
			if(map1.containsKey(chstr) == true) {
				if(map1.get(chstr) != chtarget) {
					return false;
				}
			} else {
				
				if(map2.containsKey(chtarget) == true) {
					return false;
					
				} else {
					
					map1.put(chstr, chtarget);
					map2.put(chtarget, true);
				}
			}
 		}
		return true;
	}

	public static void main(String[] args) {
		
     Scanner sc = new Scanner(System.in);
     String str = sc.next();
     String pattern = sc.next();
     
     boolean result = Isomorphic(str, pattern);
      System.out.println(result);
	}

}
