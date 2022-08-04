package HashMaps;

import java.util.*;

public class SubDomainVisitCount {
	
	private static ArrayList<String> TotalSubdomains(String domains[]){
	
		HashMap<String, Integer> map = new HashMap<>();
		StringBuilder containsAllDomain = new StringBuilder();
		
		for(String domain : domains) {
			String eachdomain[] = domain.split(" ");
			int getVisitCount = Integer.parseInt(eachdomain[0]);
			String words[] = eachdomain[1].split("\\.");
			
			for(int index = words.length - 1; index >= 0; index--) {
				
				if(index == words.length - 1) {
					containsAllDomain.append(words[index]);
					
				} else {
					
					containsAllDomain.insert(0, ".");
					containsAllDomain.insert(0, words[index]);
				}
				
				String subdomain = containsAllDomain.toString();
				
				if(map.containsKey(subdomain) == true) {
					int getcurrCount = map.get(subdomain);
					map.put(subdomain, getcurrCount + getVisitCount);
					
				} else {
					
					map.put(subdomain, getVisitCount);
				}
			}
		}
		ArrayList<String> res = new ArrayList<>();
		
		for(String subdomain : map.keySet()) {
			StringBuilder ans = new StringBuilder();
			ans.append(map.get(subdomain));
			ans.append(" ");
			ans.append(subdomain);
			res.add(ans.toString());
		}
		return res;
	}
	

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int n = Integer.parseInt(s.nextLine());
		String[] cpd = new String[n];
		for (int i = 0; i < cpd.length; i++) {
			cpd[i] = s.nextLine();
		}
		List<String> ans = TotalSubdomains(cpd);
		Collections.sort(ans);
		System.out.println(ans);
	}

}
