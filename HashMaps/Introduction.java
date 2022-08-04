package HashMaps;

import java.util.*;

public class Introduction {

	public static void main(String[] args) {
		
		HashMap<String,Integer> map = new HashMap<>();
		map.put("India", 135);
		map.put("China", 200);
		map.put("US", 50);
		
		System.out.println(map);
           
	    map.put("India", 134);
	    map.put("Nigera", 10);
	    
	    System.out.println(map);
	    
	    System.out.println(map.get("India"));
	    System.out.println(map.get("dam"));
	    
	    System.out.println(map.containsKey("India"));
	    System.out.println(map.containsKey("dum"));
	    
	    Set<String> keys = map.keySet();
	    System.out.println(keys);
	    
	    for(String key : map.keySet()) {
	    	Integer val = map.get(key);
	    	System.out.println(key + " " + val);
	    }
	}

}
