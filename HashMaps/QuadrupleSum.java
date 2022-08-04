package HashMaps;

import java.util.*;

public class QuadrupleSum {
	
	private static ArrayList<ArrayList<Integer>> fourSum(int arr[], int target){
		
		Arrays.sort(arr);
	
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		
		for(int i = 0; i < arr.length; i++) {
			if(i != 0 && arr[i] == arr[i - 1]) continue;
			
			for(int j = i + 1; j < arr.length; j++) {
				if(j != i + 1 && arr[j] == arr[j - 1]) continue;
				
				int startindex = j + 1;
				int endindex = arr.length - 1;
				
				while(startindex < endindex) {
					
					int sum = arr[i] + arr[j] + arr[startindex] + arr[endindex];
					
					if(sum > target) endindex--;
					else if(sum < target) startindex++;
					
					else {
						
			res.add(new ArrayList<Integer>(Arrays.asList(arr[i], arr[j], 
					                        arr[startindex], arr[endindex])));
			
			startindex++;
			endindex--;
			
			while(startindex < endindex && arr[startindex] == arr[startindex ] - 1) startindex++;
			while(startindex < endindex && arr[endindex] == arr[endindex] + 1) endindex--;
					}
				}
			}
		}
   return res;		
	}

	 public static void main(String[] args) {
		 
		    Scanner scn = new Scanner(System.in);
		    int n = scn.nextInt();
		    int[] arr = new int[n];
		    for (int i = 0; i < n; i++) {
		      arr[i] = scn.nextInt();
		    }
		    int target = scn.nextInt();
		  //  int n1 = arr.length;
		    ArrayList<ArrayList<Integer>> res = fourSum(arr, target);
		    ArrayList<String> finalResult = new ArrayList<>();
		    for (List<Integer> list : res) {
		      Collections.sort(list);
		      String ans = "";
		      for (int val : list) {
		        ans += val + " ";
		      }
		      finalResult.add(ans);
		    }
		    Collections.sort(finalResult);
		    for (String str : finalResult) {
		      System.out.println(str);
		    }
		  }
		}
