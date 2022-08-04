package Recursion;

import java.util.*;

public class Subset {
	
	static int counter = 0;
	public static void Ksubset(int i,int n,int k,int ssf,
			                    ArrayList<ArrayList<Integer>> ans) {
		
		if(i > n) {
			if(ssf == k) {
				counter++;
				System.out.println(counter + ".");
				for(ArrayList<Integer> set:ans) {
			// Remove each set from ans and print.		
					System.out.print(set + " ");
				}
				System.out.println();
			}
			return;
		}
		for(int j = 0; j < ans.size(); j++) {
			if(ans.get(j).size() > 0) {
				ans.get(j).add(i);
				Ksubset(i + 1,n,k,ssf,ans);
				ans.get(j).remove(ans.get(j).size() - 1);
			} else {
				ans.get(j).add(i);
				Ksubset(i + 1,n,k,ssf + 1,ans);
				ans.get(j).remove(ans.get(j).size() - 1);
			}
		}
	}
	   
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		
		for(int i = 0; i < k; i++) {
			ans.add(new ArrayList<>());
		}
		
		Ksubset(1,n,k,0,ans);
		
	}
		

}
