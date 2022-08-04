package HashMaps;

import java.util.*;

public class PowerfulNumber {
	
	private static ArrayList<Integer> powerfulNumber(int x, int y, int bound){
		
		HashSet<Integer> set = new HashSet<>();
		
		 for(int i = 1; i < bound; i *= x) {
			 for(int j = 1; i + j <= bound; j *= y) {
				 set.add(i + j);
				 if(y == 1) break;
			 }
			 if(x == 1) break;
		 }
		return new ArrayList<>(set);
		
	}

	public static void main(String[] args) {
	 
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int bound = sc.nextInt();

		ArrayList<Integer> res = powerfulNumber(x, y, bound);
		 System.out.println(res);
		
	}

}
