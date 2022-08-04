package Recursion;

import java.util.*;

public class GetStairsPathWithJump {
	
public static ArrayList<String> getmazepaths(int sr,int sc,int dr,int dc){
		
	if(sr == dr && sc == dc) {
		ArrayList<String> base = new ArrayList<>(); // Base Case
		base.add("");
		return base;
	}
		ArrayList<String> paths = new ArrayList<>();
		
		//HORIZONTAL MOVES
	for(int h = 1; h <= dc - sc; h++) {
		ArrayList<String> hpaths = getmazepaths(sr,sc + h,dr,dc);
		for(String hpath:hpaths) {
			paths.add("h" + h + hpath);
		}
	}
	//VERTICAL MOVE
	for(int v = 1; v <= dr - sr; v++) {
		ArrayList<String> vpaths = getmazepaths(sr + v,sc,dr,dc);
		for(String vpath:vpaths) {
			paths.add("v" + v + vpath);
		}
	}
	//DIAGONAL PATH
	for(int d = 1; d <= dr - sr && d <= dc - sc; d++) {
		ArrayList<String> dpaths = getmazepaths(sr + d,sc + d,dr,dc);
		for(String dpath:dpaths) {
			paths.add("d" + d + dpath);
		}
	}
	return paths;
	}
	

	public static void main(String[] args) {

  Scanner sc = new Scanner(System.in);
         int n = sc.nextInt();
         int m = sc.nextInt();
 ArrayList<String> paths = getmazepaths(1,1,n,m);
  System.out.println(paths);
	}

}
