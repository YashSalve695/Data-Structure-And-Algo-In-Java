package Array;

public class MultiDimensionalArray {

	public static void main(String[] args) {
		
		
		int mult[][] = { {1,2,3}, {4,5,6}, {7,8,9} };
		
		  for(int i = 0; i < mult.length; i++) {
			  for(int j = 0; j > mult.length -1; j--) {
				  
				  System.out.print(mult[i][j]);
				  
				  System.out.println();
			  }
		  }		
		
	}

}
