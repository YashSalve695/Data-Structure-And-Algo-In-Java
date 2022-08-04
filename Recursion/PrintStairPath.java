package Recursion;

import java.util.Scanner;

public class PrintStairPath {
	
	public static void printstairpath(int n,String path) {
		
		if(n < 0) {
			return;
		}
		if(n == 0) {
			System.out.println(path);
			return;
		}
		
		/** INSTRUCTION TO PRINT THE PATH */
		printstairpath(n - 1,path + "1");
		printstairpath(n - 2,path + "2");
		printstairpath(n - 3,path + "3");
    	
	}

	public static void main(String[] args) {
		
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      
      printstairpath(n,"");
	}

}
