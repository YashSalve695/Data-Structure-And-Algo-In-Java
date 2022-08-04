package ArraysL2;

import java.util.*;
/**

1. Given an integer array nums of length n where all the integers of nums are in the range [1, n].
2. Each integer appears once or twice, return an array of all the integers that appears twice.
3. You must write an algorithm that runs in O(n) time and uses only constant extra space.

8
4 3 2 7 8 2 3 1

2 3

*/

public class FindAllDuplicates {

	public static List<Integer> findDuplicates(int[] nums) {
		
		List<Integer> ans = new ArrayList<>();
		
		for(int i = 0; i < nums.length; i++) {
			int index = Math.abs(nums[i]) - 1;
			/** absolute because if we have negative value
			    already present in the array */
			
			int val = nums[index];
			
			if(val < 0) {
				ans.add(index + 1);
			} else {
		    	nums[index] *= -1;
		 }
		}
		
		return ans;
	 	  }

		  // ~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~
		  public static void main(String[] args) {
		    Scanner scn = new Scanner(System.in);
		    int n = scn.nextInt();
		    int[] arr = new int[n];
		    
		    for (int i = 0; i < n; i++) {
		      arr[i] = scn.nextInt();
		    }

		    List<Integer> res = findDuplicates(arr);
		    if (res.size() == 0) {
		      System.out.println("Empty");
		      return;
		    }
		    Collections.sort(res);
		    for (int val : res)
		      System.out.print(val + " ");
		    System.out.println();
		  }
		}