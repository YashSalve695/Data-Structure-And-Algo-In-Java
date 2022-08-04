package HashMaps;

import java.util.*;

public class FindItineraryUsingtickets {

	public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    /** INPUT */
    int source_and_des = sc.nextInt();
    
    HashMap<String, String> map = new HashMap<>();
     for(int i = 0; i < source_and_des; i++) {
    	 String source = sc.next();
    	 String destination = sc.next();
    	 map.put(source, destination);
     }
     
     HashMap<String, Boolean> oursource = new HashMap<>();
     for(String source : map.keySet()) {
    	 String dest = map.get(source);
    	 
    	 oursource.put(dest, false);
    	 if(oursource.containsKey(source) == false) {
    		 oursource.put(source, true);
    	 }
     }
     String src = "";
      for(String pot : oursource.keySet()) {
    	  Boolean val = oursource.get(pot);
    	  if(val == true) {
    		  src = pot;
    		  break;
    	  }
      }
      while(true) {
    	  
    	  if(map.containsKey(src) == true) {
    		 System.out.print(src + " " + "->" + " ");
    		  src = map.get(src);
    		 
    	  } else {
    		
    		  System.out.print(src + ".");
    		  break;	
    	  }
      }
	}

}
