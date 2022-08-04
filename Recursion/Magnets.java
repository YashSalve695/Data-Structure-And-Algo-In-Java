package Recursion;

import java.util.Arrays;
import java.util.Scanner;

public class Magnets {
	
	public static void print(char arr[][]) {
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static boolean IsAnsValid(char[][] ans,int top[],int left[],
			                     int right[],int bottom[]) {
		
		for(int i = 0;i < top.length; i++) {
			int cinc = countinCol(ans,top,'+',i);
			if(top[i] != -1 && top[i] != cinc) {
				return false;
			}
		}
		for(int i = 0; i < left.length; i++) {
			int cinr = countinRow(ans,left,'+',i);
			if(left[i] != -1 && left[i] != cinr) {
				return false;
			}
		}
		for(int i = 0; i < bottom.length; i++) {
			int cinc = countinCol(ans,bottom,'-',i);
			if(bottom[i] != -1 && bottom[i] != cinc) {
				return false;
			}
		}
		for(int i = 0; i < right.length; i++) {
			int cinr = countinRow(ans,right,'-',i);
			if(right[i] != -1 && right[i] != cinr) {
				return false;
			}
		}
		return true;
	}
	
	public static int countinCol(char[][] ans,int arr[],int sign,
            int colno) {

              int counter = 0;
               for(int row = 0; row < ans.length; row++) {
                 if(ans[row][colno] == sign) {
                       counter++;
               }
         }
        return counter;
    }
	
	public static int countinRow(char[][] ans,int arr[],int sign,
			                                      int rowno) {
		
		 int counter = 0;
		 for(int col = 0; col < ans[0].length; col++) {
			 if(ans[rowno][col] == sign) {
				 counter++;
			 }
		 }
		 return counter;
	}
	
	
	
	public static boolean IsItSafe(char[][] ans,int top[],int left[],
			  int right[],int bottom[],int row,int col,char sign) {
		
		if((col - 1 >= 0 && ans[row][col - 1] == sign) ||
		  (row - 1 >= 0 && ans[row - 1][col] == sign) ||
		  (col + 1 < ans.length && ans[row][col + 1] == sign)) {
			
			return false;
		}
		if(sign == '+') {
		int cinr = countinRow(ans,left,sign,row);
		int cinc = countinCol(ans,top,sign,col);
		
		if(left[row] != -1 && cinr >= left[row]) {
			return false;
		    }
		if(top[col] != -1 && cinr >= top[col]) {
			return false;
		    }

		if(right[row] != -1 && cinr >= bottom[row]) {
			return false;
		    }
		if(right[col] != -1 && cinr >= left[col]) {
			return false;
		    }
		}
		return true;
	}
	
	
    public static boolean solution(char[][] arr,int top[],int left[],
    		                  int right[],int bottom[],char[][] ans,
    		                  int row,int col) {
    	
    	if(col == arr[0].length) {
    		col = 0;
    		row++;
    	}
    	if(row == arr.length) {
    		if(IsAnsValid(ans,top,left,right,bottom) == true) {
    			return true;
    		}
    		    return false;
    	}
    	
    	if(arr[row][col] == 'L') {
    		if(IsItSafe(ans,top,left,right,bottom,row,col,'+') &&
    		IsItSafe(ans,top,left,right,bottom,row,col + 1,'-')){
    			
    	ans[row][col] = '+';
    	ans[row][col + 1] = '-';
    if(solution(arr,top,left,right,bottom,ans,row,col + 2) == true) {
    		return true;
    	}
    	ans[row][col] = 'X';
    	ans[row][col + 1] = 'X';		
    		}	
    	if(IsItSafe(ans,top,left,right,bottom,row,col,'-') && 
    	   IsItSafe(ans,top,left,right,bottom,row, col + 1,'+')) {
    		
    		ans[row][col] = '-';
        	ans[row][col + 1] = '+';
     if(solution(arr,top,left,right,bottom,ans,row,col + 2) == true) {
        	return true;
        }
        	ans[row][col] = 'X';
        	ans[row][col + 1] = 'X';	
    		 }
    	} else if(arr[row][col] == 'T') {
    		if(IsItSafe(ans,top,left,right,bottom,row,col,'+') &&
    		   IsItSafe(ans,top,left,right,bottom,row + 1,col,'-')) {
    			
    		ans[row][col] = '+';
           	ans[row + 1][col] = '-';
      if(solution(arr,top,left,right,bottom,ans,row,col + 1) == true) {
    	  return true;
      }
            ans[row][col] = 'X';
           	ans[row + 1][col] = 'X';		
    		}
    		if(IsItSafe(ans,top,left,right,bottom,row,col,'-') &&
    	       IsItSafe(ans,top,left,right,bottom,row + 1,col,'+')) {
    		
    		ans[row][col] = '-';
            ans[row + 1][col] = '+';
      if(solution(arr,top,left,right,bottom,ans,row,col + 1) == true) {
    	  return true;
      }
            ans[row][col] = 'X';
            ans[row + 1][col] = 'X';
    		}
    	}
    	boolean f2 = solution(arr,top,left,right,bottom,ans,row,
    			                         col + 1);
    	
    	if(f2 == true) {
    		return true;
    	}
    	return false;
    	
    }
	
	public static void main(String[] args) {

      Scanner sc = new Scanner(System.in);
      int m = sc.nextInt();
      int n = sc.nextInt();
         char arr[][] = new char[m][n];
           for(int i = 0; i < arr.length; i++) {
        	   String str = sc.next();
        	   arr[i] = str.toCharArray();
           }
      int top[] = new int[n];
       for(int i = 0; i < n; i++) {
    	   top[i] = sc.nextInt();
       }
       int left[] = new int[n];
       for(int i = 0; i < n; i++) {
    	   left[i] = sc.nextInt();
       }
       int right[] = new int[n];
       for(int i = 0; i < n; i++) {
    	   right[i] = sc.nextInt();
       }
       int bottom[] = new int[n];
       for(int i = 0; i < n; i++) {
    	   bottom[i] = sc.nextInt();
       }
       char[][] ans = new char[m][n];
       
       for(int i = 0; i < m; i++) {
    	  Arrays.fill(ans[i],'X');
    	  
    	  if(!solution(arr,top,left,right,bottom,ans,0,0)) {
    		  System.out.println("N0 SOLUTION");
    		  return;
    	  }
    	  print(ans);
       }

	}

}
