package HashMaps;

import java.util.*;

public class GroupAnagrams {
	
	public static ArrayList<ArrayList<String>> groupAnagrams(String[] str){
		
		HashMap<HashMap<Character, Integer>, ArrayList<String>> bmap = new HashMap<>();
		
		 for(String s : str) {
			 HashMap<Character, Integer> map = new HashMap<>();
			  for(int i = 0; i < s.length(); i++) {
				  char ch = s.charAt(i);
				  map.put(ch, map.getOrDefault(ch, 0) + 1);
			  }
			  
			  if(bmap.containsKey(map) == false) {
				  ArrayList<String> list = new ArrayList<>();
				  list.add(s);
				  bmap.put(map, list);
				   
			  } else {
				  
				  ArrayList<String> list = bmap.get(map);
				  list.add(s);
			  }
		 }
		 ArrayList<ArrayList<String>> res = new ArrayList<>();
		  for(ArrayList<String> val : bmap.values()) {
			  res.add(val);
		  }
		  return res;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[] arr = new String[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.next();
		}
		ArrayList<ArrayList<String>> anagramsGrouped = groupAnagrams(arr);
		for (ArrayList<String> lst : anagramsGrouped) {
			Collections.sort(lst);
		}
		anagramsGrouped.sort(new ListComparator());
		display(anagramsGrouped);
	}

	// it is used to make the result unique
	static class ListComparator implements Comparator<List<String>> {
		
		public int compare(List<String> l1, List<String> l2) {
			if (l1.size() != l2.size()) {
				return l2.size() - l1.size();
			}

			String l1str = l1.get(0);
			String l2str = l2.get(0);
			return l1str.compareTo(l2str);

		}
	}

	public static void display(ArrayList<ArrayList<String>> list) {
		for (int i = 0; i < list.size(); i++) {
			ArrayList<String> currList = list.get(i);
			for (int j = 0; j < currList.size(); j++) {
				System.out.print(currList.get(j) + " ");
			}
			System.out.println();
		}
	}

}
