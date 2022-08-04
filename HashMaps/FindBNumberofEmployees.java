package HashMaps;

import java.util.*;

public class FindBNumberofEmployees {
	
	private static void findcount(HashMap<String, String> map) {
		
		HashMap<String, HashSet<String>> tree = new HashMap<>();
		String ceo = "";
		
		 for(String employee : map.keySet()) {
			 String manager = map.get(employee);
			 
			 if(manager.equals(employee)) {
				 ceo = manager;
				 
			 } else {
				 
				 if(tree.containsKey(manager)) {
					 HashSet<String> employees = tree.get(manager);
					 employees.add(employee);
					 
				 } else {
					 
					 HashSet<String> employees = new HashSet<>();
					 employees.add(employee);
					 tree.put(manager, employees); 
 				 }
			 }
		 }
		 HashMap<String, Integer> result = new HashMap<>();
		 getsize(tree, ceo, result);
		 
		 for(String emp : result.keySet()) {
			 System.out.println(emp + " " + result.get(emp));
		 }
	}
	private static int getsize(HashMap<String, HashSet<String>> tree, String manger,
			                          HashMap<String, Integer> result) {
		
		if(tree.containsKey(manger) == false) {
			result.put(manger, 0);
			return 1;
		}
		
		int size = 0; 
		for(String emp : tree.get(manger)) {
			int empSize = getsize(tree, emp, result);
			size += empSize;
		}
		result.put(manger, size);
		return size + 1;
	}
 
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		HashMap<String, String> map = new HashMap<>();
		 for(int i = 0; i < n; i++) {
			 map.put(sc.next(), sc.next());
		 }
		findcount(map);
	}

}
