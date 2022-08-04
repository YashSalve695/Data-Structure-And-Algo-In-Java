package Array;

import java.util.Scanner;

public class MajorityElements {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		for(int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		int ansIndex = 0;
		int count = 1;
		
		for(int i = 1; i < a.length; i++) {
			if (a[i] == a[ansIndex]) {
				count++;
			}else {
				count--;
			}
			if(count == 0) {
				ansIndex = a[i];
				count = 1;
			}
//			for(item:a) {
//				System.out.println(item);
//			}
		System.out.println(a[i]);
		}
		
	}

}
