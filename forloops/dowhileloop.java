package forloops;

import java.util.Scanner;

public class dowhileloop {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		  int n = scanner.nextInt();
		     
		     	int temp = n;
		     	int sum = 0;
		     	while(temp > 0) {
		     		
		     		int lastDigit = temp % 10;
		     		temp /=10;
		     		
		sum += lastDigit;
		System.out.println(lastDigit +"  "+ temp +"  "+sum);
		     	}
               System.out.println("the sum of digit " + n +"  is " + sum);
	}

}
