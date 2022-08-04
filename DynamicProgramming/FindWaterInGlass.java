package DynamicProgramming;

import java.util.*;

public class FindWaterInGlass {
	
	/**
	
1. coder arranged some glasses in the form of pascal triangle.
2. Capacity of each glass is 1 litre. If you pour K amount of water in a glass, it will retain 1 litre and
   rest of it gets equally distributed in left bottom glass and right bottom glass.
3. If coder pours K litres of water in the topmost glass, you have to find out the amount of water in Cth glass of Rth row.

Assumption -> There are enough glasses in the triangle till no glass overflows.	
	
3
1
0

1.0
	
	
	*/
	public static double champagneTower(int poured, int qr, int qc) {
        if(poured == 0)
           return 0;
       
       double total = poured;
       double ans[][] = new double[100][100]; //array to store remaining poured quantity
       
       int i=0;
       ans[0][0] = total;
       
       while(ans[qr][qc]<1 && i<=qr){  //till the asked row'th glass is not reached
           boolean found = false;
           for(int j = 0; j <= i; j++){
               if(ans[i][j]<=1)   
                   continue;
               
               double extra = ans[i][j] - 1;   //calculating the extra quantity which will be left
                 if(i + 1 < 100){                   //      if not the last row
                   ans[i+1][j] += extra/2;      //pouring the left quantity equally
                   ans[i+1][j+1] += extra/2;
                   found = true;
               }
           }
           i++;
           if(!found)
               break;
       }
      
       if(ans[qr][qc]>=1)
           return 1;
       return ans[qr][qc];
   
}

	

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();
		
		double ans = champagneTower(k, r, c);
		 System.out.println(ans);

	}

}
