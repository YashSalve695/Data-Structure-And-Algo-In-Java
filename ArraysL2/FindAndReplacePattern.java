package ArraysL2;
import java.util.*;

/**

1. Given a list of strings words and a string pattern.
2. Return a list of words[i] that match pattern. You may return the answer in any order.
3. A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the pattern with p(x), we get the desired word.
4. Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter, and no two letters map to the same letter.


epp
6
mno
rst
rss
bll
lml
aaa

bll rss

*/
public class FindAndReplacePattern {
	
   public static boolean isMatching(String word, String pattern) {
	   HashSet<Character> set = new HashSet<>();
	   HashMap<Character, Character> map = new HashMap<>();
	    for(int i = 0; i < word.length(); i++) {
	    	char word_ch = word.charAt(i);
	    	char pat_ch = pattern.charAt(i);
	    	
	    	if(map.containsKey(pat_ch) == true) {
	    		/** pattern char is already map*/
	    		if(map.get(pat_ch) != word_ch) return false;
	    	} else {
	    		/** pattern char is not mapped */
	    		if(set.contains(word_ch)) {
	    			return false;
	    		}
	    		map.put(pat_ch, word_ch);
	    		set.add(word_ch);
	    	}
	    }
	   return true;
   } 
	public static List<String> findAndReplacePattern(String[] words, String pattern) {
	   
		List<String> ans = new ArrayList<>();
		
		for(String word : words) {
			if(isMatching(word, pattern)) {
				ans.add(word);
			}
		}
		return ans;
	  }

	  // ~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~
	  public static void main(String[] args) {
	    Scanner scn = new Scanner(System.in);
	    String pattern = scn.nextLine();
	    int n = scn.nextInt();
	    scn.nextLine(); // to consume enter after number
	    String[] words = new String[n];
	    for (int i = 0; i < n; i++) {
	      words[i] = scn.nextLine();
	    }
	    List<String> res = findAndReplacePattern(words, pattern);
	    if (res.size() == 0) {
	      System.out.println("Empty");
	      return;
	    }
	    Collections.sort(res);
	    for (String str : res) {
	      System.out.print(str + " ");
	    }
	    System.out.println();
	  }
	}