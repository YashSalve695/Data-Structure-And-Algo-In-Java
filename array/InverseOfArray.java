package Array;

public class InverseOfArray {
	
public static void printArray(int a[]) {
		
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
			System.out.println();

	}
	
	public static int[] inverse(int a[]) {
		
		int inv[] = new int[a.length];
		
		
		for(int i = 0; i < a.length; i++) {
			int v = a[i];
			a[i] = v;
		}
		return inv;
	}

	public static void main(String[] args) {

       int arr[] = {1,4,3,6,7};
        
     inverse(arr);
     printArray(arr);
     
	}

}
