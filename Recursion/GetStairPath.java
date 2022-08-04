package Recursion;

import java.util.*;

public class GetStairPath {
	
	public static ArrayList<String> getstairpath(int n){
		
		if(n == 0) {
		ArrayList<String> bres = new ArrayList<>();
		bres.add("");
		return bres;
		
	 } else if(n < 0) {
		 ArrayList<String> bres = new ArrayList<>();
			return bres;
	 }
		
		/** RECURSIVE CALLS */
		ArrayList<String> path1 =  getstairpath(n - 1);
		ArrayList<String> path2 =  getstairpath(n - 2);
		ArrayList<String> path3 =  getstairpath(n - 3);
		
		ArrayList<String> paths = new ArrayList<>();
		
		for(String path : path1) {
			paths.add(path + 1);
		}
		for(String path : path2) {
			paths.add(path + 2);
		}
		for(String path : path3) {
			paths.add(path + 3);
		}
		return paths;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		ArrayList<String> paths = getstairpath(n);
		 System.out.println(paths);
	
	}

}
