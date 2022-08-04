package Recursion;

import java.util.*;

public class TugOfWar { // LEVELS AND OPTIONS APPROACH.
	
	  public static void TOW(int []arr,int index,ArrayList<Integer>
      set1,ArrayList<Integer> set2,int soset1,int soset2) {
		  
		  if(index == arr.length) {
			  int delta = Math.abs(soset1 - soset2);
			  if(delta < mindiff) {
				  mindiff = delta;
				  ans = set1 + " " + set2;
			  }
			  return;
		  }
		  
     
		  if(set1.size() < (arr.length + 1) / 2) {
	// If array is odd then plus 1 and divide.		  
			  set1.add(arr[index]);
	// Add index in set1 .		  
			  TOW(arr,index + 1,set1,set2,soset1 + arr[index],soset2);
	// Increase index and add in sum of set1.		  
			  set1.remove(set1.size() - 1); // BACTRACK
	// After going back to set2 remove the last index from set1.		  
		  }
		  
		  
		  if(set2.size() < (arr.length + 1) / 2) {
	// If array is odd then plus 1 and divide.		  
			  set2.add(arr[index]);
	// Add index in set2.	
			  TOW(arr,index + 1,set1,set2,soset1,soset2 + arr[index]);
	// Increase index and add in sum of set2.	
			  set2.remove(set2.size() - 1);
	// After going up in levels make it empty.
		  }
   }


	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int arr[] = new int[sc.nextInt()];
		  for(int i = 0; i < arr.length; i++) {
			  arr[i] = sc.nextInt();
		  }
		  TOW(arr,0,new ArrayList<>(),new ArrayList<>(),0,0);
           System.out.println(ans);
	}
	static int mindiff = Integer.MAX_VALUE;
    static String ans = " ";
}
