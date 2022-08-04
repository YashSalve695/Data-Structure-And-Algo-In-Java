package HashMaps;

import java.util.*;

public class BrickWall {
	
	private static int leastBricks(List<List<Integer>> wall) {
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		int max = 0;
		
		for(List<Integer> list : wall) {
			int prefixsum = 0;
			
			for(int index = 0; index < list.size(); index++) {
				int val = list.get(index);
				
				prefixsum += val;
				
				map.put(prefixsum, map.getOrDefault(prefixsum, 0) + 1);
				max = Math.max(max, map.get(prefixsum));
			}
		}
		return wall.size() - max;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		List<List<Integer>> res = new LinkedList<>();
		
		int ans = leastBricks(res);
		 System.out.println(ans);
		
		

	}

}
