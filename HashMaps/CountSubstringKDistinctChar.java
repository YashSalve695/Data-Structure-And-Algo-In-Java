package HashMaps;

import java.util.*;

public class CountSubstringKDistinctChar {
	
	private static int KdistinctSubstring(String s, int k) {
		
		int ans = 0;
		
		int i = -1;
		int j = -1;
		
		HashMap<Character, Integer> map = new HashMap<>();
		
		while(true) {
			while(i < s.length() - 1) {
				i++;
				char ch = s.charAt(i);
				map.put(ch, map.getOrDefault(ch, 0) + 1);
				
				if(map.size() <= k) {
					ans += i - j;
				} else {
					break;
				}
			}
			if(i == s.length() - 1 && map.size() <= k) {
				break;
			}
			while(j < i) {
				j++;
				char ch = s.charAt(j);
				if(map.get(ch) == 1) {
					map.remove(ch);
				}else {
					map.put(ch, map.getOrDefault(ch, 0) - 1);
				}
				
				if(map.size() > k) {
					continue;
				} else {
					ans += i - j;
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int k = sc.nextInt();
		
		int res = KdistinctSubstring(s, k);
		 System.out.println(res);
	}
}
