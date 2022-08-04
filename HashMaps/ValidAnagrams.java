package HashMaps;

import java.util.*;

public class ValidAnagrams {
	
	public static boolean validAnagrams(String s1, String s2) {
		
		HashMap<Character, Integer> map = new HashMap<>();
		
		/** Make freq map for string s1 */
		for(int i = 0; i < s1.length(); i++) {
			char chs1 = s1.charAt(i);
			map.put(chs1, map.getOrDefault(chs1, 0) + 1);
		}
		
		for(int i = 0; i < s2.length(); i++) {
			char chs2 = s2.charAt(i);
			
			if(map.containsKey(chs2) == false) {
				return false;
				
			} else if(map.get(chs2) == 1) {
				map.remove(chs2);
				
			} else {
				
				map.put(chs2, map.getOrDefault(chs2, 0) - 1);
			}
		}
		return map.size() == 0;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();
		
		boolean res = validAnagrams(s1, s2);
		 System.out.println(res);
	}

}
