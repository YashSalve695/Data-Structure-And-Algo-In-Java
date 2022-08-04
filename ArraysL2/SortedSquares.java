package ArraysL2;

import java.util.Scanner;

public class SortedSquares {

    public static void printarray(int arr[]) {
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
    public static int[] sortedSquares(int[] nums) {
    	
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i]*nums[i];
        }

        int[] res = new int[nums.length];
        
        int i = 0;
        // i will be at starting index.
        
        int j = nums.length-1;
        // j will be at last index.
        
        int k = nums.length-1;

        while(i <= j){
            if(nums[i] < nums[j]){
				//if element at index i is bigger than element at index j, move it to res[k] and increase i
                res[k] = nums[i];
                k--;
                i++;
            } else {
           
				// if element at index j is bigger than element at index i, move it to res[k] and decrease i
                res[k] = nums[j];
                k--;
                j--;
            }
        }

        return res;
    }
    
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        
        for(int i = 0; i < n; i++) 
            arr[i] = scn.nextInt();
        
       
			int[] result = sortedSquares(arr);
		

        for(int i = 0; i < n; i++) {
            System.out.print(result[i] + " ");
        } 
    }
	}

