 package ArraysL2;

import java.util.*;

public class MajorityElement2 {
	
	public static boolean isvalidby3(int arr[],int val) {
		
		int count = 0;
		for(int element : arr) {
			if(element == val) {
				count++;
			}
		}
		return count > arr.length / 3;
	}
	
	public static ArrayList<Integer> majorityElement2(int arr[]){
		
		int val1 = arr[0];
		int count1 = 1;
		
		int val2 = arr[0];
		int count2 = 0;
		
		int i = 0;
		 while(i < arr.length) {
			 
			 if(arr[i] == val1) {
				 count1++;
				 
			 } else if(arr[i] == val2) {
				 count2++;
				 
			 } else {
				 if(count1 == 0) {
					 val1 = arr[i];
					 count1 = 1;
					 
				 } else if(count2 == 0) {
					 val2 = arr[i];
					 count2 = 1;
					 
				 } else {
					 count1--;
					 count2--;
				 }
			 }
			 i++;
		 }
		 ArrayList<Integer> res = new ArrayList<>();
		    
		    if(isvalidby3(arr,val1) == true) {
		    	res.add(val1);
		    }
		    if(val1 != val2 && isvalidby3(arr,val2) == true) {
		    	res.add(val2);
		    }
		 return res;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		
		int arr[] = new int[n];
		 for(int i = 0; i < n; i++) {
			 arr[i] = sc.nextInt();
		 }
      ArrayList<Integer> res = majorityElement2(arr);
        System.out.println(res);
	}

}
