package HashMaps;

import java.util.*;

public class HigestFreqCharacter {

	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
	
		String str = sc.next();
		
		HashMap<Character,Integer> map = new HashMap<>();
		
		 for(int i = 0; i < str.length(); i++) {
			 char ch = str.charAt(i);
		// Remove each character in the string	 
			 
			 if(map.containsKey(ch)) {
		// If map contains that character.		 
				 int oldfreq = map.get(ch);
		// Get that character in the map.		 
				 int newfreq = oldfreq + 1;
		// And make that char incerement by 1;		 
				 map.put(ch, newfreq);
		// And again put that char in map,with
		// updated frequency.		 
			
			 } else {
		// And if that char is is new than
		// add the char in map with first char.		 
				 map.put(ch, 1);
			 }
		 }
		 char maxfreq = str.charAt(0);
		 // Set first char of the string as our max char.
		  for(Character key : map.keySet()) {
		// Then take out every key in character	  
			  if(map.get(key) > map.get(maxfreq)) {
				  maxfreq = key;
		// If that char present max times in the string.
		// Then update maxfreq to that key.		  
			  }
		  }
		  System.out.println(maxfreq);
		  // return maxfreq.
	}

}
