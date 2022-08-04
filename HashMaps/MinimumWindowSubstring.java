package HashMaps;

import java.util.*;

public class MinimumWindowSubstring {
	
	private static String MinWindowSubstring(String s1, String s2) {
		
		String ans = "";
		
		HashMap<Character, Integer> maps2 = new HashMap<>();
		 for(int index = 0; index < s2.length(); index++) {
			 char ch = s2.charAt(index);
			 maps2.put(ch, maps2.getOrDefault(ch, 0) + 1);
		 }
		 int matchCount = 0;
		 int desireMatchCount = s2.length();
		 
		 HashMap<Character, Integer> maps1 = new HashMap<>();
		 
		 int acquire = -1;
		 int release = -1;
		 
		 while(true) {
			 
			 boolean f1 = false;
			 boolean f2 = false;
			 
			 while(acquire < s1.length() - 1 && matchCount < desireMatchCount) {
				 acquire++;
				 char ch = s1.charAt(acquire);
				 maps1.put(ch, maps1.getOrDefault(ch, 0) + 1);
				 
				 if(maps1.getOrDefault(ch, 0) <= maps2.getOrDefault(ch, 0)) {
					 matchCount++;
				 }
				 f1 = true;
			 }
			 while(release < acquire && matchCount == desireMatchCount) {
				 String potAns = s1.substring(release + 1, acquire + 1);
				 
				 if(ans.length() == 0 || potAns.length() < ans.length()) {
					 ans = potAns;
				 }
				 release++;
				 char ch = s1.charAt(release);
				 if(maps1.get(ch) == 1) {
					 maps1.remove(ch);
					 
				 } else {
					 
					 maps1.put(ch, maps1.get(ch) - 1);
				 }
				 if(maps1.getOrDefault(ch, 0) < maps2.getOrDefault(ch, 0)) {
					 matchCount--;
				 }
				 f2 = true;
			 }
			 if(f1 == false && f2 == false) {
				 break;
			 }
		 }
		return ans;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String one = sc.next();
		String two = sc.next();
		
		String res = MinWindowSubstring(one, two);
		 System.out.println(res);
		
	}

}
