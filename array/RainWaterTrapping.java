package Array;

public class RainWaterTrapping {
	
	public static int trapped(int a[]) {
		
		int n = a.length;
       //  AUXILLARY ARRAYS ARE USED (SPACE)     
		int left[] = new int[n];
		int right[] = new int[n];
		int Ans = 0;
		
		
		left[0] = a[0];
		/**
		 left[i - 1] = 
		 */
		 for(int i = 1; i < n; i++) {
			 left[i] = Math.max(left[i - 1],a[i]);
		 }
		 right[n - 1] = a[n - 1];
		  for(int i = n - 2; i >= 0; i--) {
			  right[i] = Math.max(right[i + 1], a[i]);
		  }
		  for(int i = 0; i < n; i++) {
			  Ans += Math.min(left[i],right[i]) - a[i];
		  }
		  return Ans;
		 
		 }

	public static void main(String[] args) {

    int arr[] = {1, 5, 4, 3, 2, 9};
   
    
      System.out.println("maximum water trapped is " + trapped(arr));
    

	}

}
