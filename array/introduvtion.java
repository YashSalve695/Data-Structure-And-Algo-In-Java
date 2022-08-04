package Array;

import java.util.Scanner;

public class introduvtion {

	public static void main(String[] args) {
	  
		System.out.println("Enter the number of students");
		
		Scanner sc = new Scanner(System.in);
		 int n = sc.nextInt();
		 
	int marks = new int[n];
	   for(int i = 0; i<=n; i++) {
		 int marks[i] = (int) sc.nextInt();
	   }
	     int averageMarks = 0;
	
	
     for(int i = 0; i < n; i++) {
    	  averageMarks +=  marks[i];
     }
     
     averageMarks /=n;
     System.out.println("the average marks are" + averageMarks);
}
	
