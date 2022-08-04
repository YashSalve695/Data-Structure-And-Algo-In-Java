package HashMaps;

import java.util.*;

public class FractionToRecurringDecimal {
	
	private static String RecurringElement(int num, int deno) {
		
		StringBuilder ans = new StringBuilder();
		
		int quo = num / deno;
		int rem = num % deno;
		ans.append(quo);
		
		if(rem == 0) {
			return ans.toString();
			
		} else {
			
		ans.append(".");
		HashMap<Integer, Integer> map = new HashMap<>();
		
		while(rem != 0) {
			if(map.containsKey(rem)) {
				int len = map.get(rem);
				ans.insert(len, "(");
				ans.append(")");
				break;
				
			} else {
				
				map.put(rem, ans.length());
				rem *= 10;
				quo = rem / deno;
				rem = rem % deno;
				ans.append(quo);
			}
		}
	}
		return ans.toString();
}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int numerator = sc.nextInt();
		int denominator = sc.nextInt();
		
		String ans = RecurringElement(numerator, denominator);
		 System.out.println(ans);
		

	}

}
