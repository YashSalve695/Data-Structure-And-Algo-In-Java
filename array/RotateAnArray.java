package Array;

public class RotateAnArray {
	
//	UTILITY FUNCTION TO PRINT ARRAY
	public static void printArray(int arr[]) {
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
			System.out.println();
		
	}
		
	
	public static void reverse(int a[]) {
		
	int i = 0;
		int j = a.length - 1;
		while(i < j) {	
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;	
			
            i++;
			j--;
	}
      }

	 public static void reversed(int a[],int i,int j) {
		 
		 int left = i;
		 int right = j;
		 while(left < right) {
			 
			 int temp = a[left];
			 a[left] = a[right];
			 a[right] = temp;
			 
			 left++;
			 i--;
		 }
	 }
	public static void rotatek(int a[],int k) {
		
  	k = k % a.length;
		if(k < 0) {
			k = k + a.length;
			
//			PART 1 REVERSE
			reversed(a,0,a.length - k - 1);
			
//			PART 2 REVERSE
			reversed(a,a.length - k,a.length - 1);
			
//			PART 2 REVERSE
			reversed(a,0,a.length - 1);
				
		}	
		}
	
	
	
	public static void main(String[] args) {
		
		int arr[] = {1,2,3,4,5};
	  int k = 3;
		
		
		
		printArray(rotatek(arr,k));
		 
		}
	}

