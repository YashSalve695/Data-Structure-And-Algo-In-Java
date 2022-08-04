package Recursion;

import java.util.*;

public class GetMazePath {
	
public static ArrayList<String> getmazepaths(int sourcerow,
	int sourcecolumn,int destinationrow,int destinationcolumn){
		
	/** BASE CASE */
    if(sourcerow == destinationrow && sourcecolumn == destinationcolumn) {
	       ArrayList<String> bres = new ArrayList<>();
	       bres.add("");
	           return bres;
}

      ArrayList<String> hpaths = new ArrayList<>();
      ArrayList<String> vpaths = new ArrayList<>();

                 if(sourcerow < destinationrow) { /** HORIZONTAL PATHS */
	        hpaths = getmazepaths(sourcerow + 1,sourcecolumn,
			destinationrow,destinationcolumn);
  }
                 if(sourcecolumn < destinationcolumn) { /** VERTICAL PATHS */
        	vpaths = getmazepaths(sourcerow,sourcecolumn + 1,
			destinationrow,destinationcolumn);
	
}
        ArrayList<String> paths = new ArrayList<>();
 
                 for(String hpath:hpaths) {
	                 paths.add("h" + hpath);
                  }
 
                 for(String vpath:vpaths) {
	                 paths.add("v" + vpath);
                  }
           return paths;
}
	

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		ArrayList<String> path = getmazepaths(1,1,m,n);
		System.out.println(path);
	}

}
