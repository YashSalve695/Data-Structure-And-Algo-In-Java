package Recursion;

import java.util.*;

public class GetKeypadSolution {
	
       static  String[] codes = {".;","abc","def","ghi","jkl",
		                              "mno","pqrs","tu","vwx","yz"};
  
     public static ArrayList<String> getKPC(String str){
	
	if(str.length() == 0) {
		ArrayList<String> baseresult = new ArrayList<>();
		baseresult.add("");
		return baseresult;
	}
	/** IT WILL REMOVE THE FIRST CHARACTER IN THE STRING */
	char ch = str.charAt(0);
	
	/** THIS WILL GIVE US SUBSTRING OF REST OF THE STRING */
	String restofstring = str.substring(1);
	
	/** IT WILL STORE ALL THE SUBSTRING */
	ArrayList<String> recursionresult = getKPC(restofstring);
	
	ArrayList<String> myresult = new ArrayList<>();
	
	String codeforch = codes[ch - '0'];
	for(int i = 0; i < codeforch.length(); i++) {
		char chcode = codeforch.charAt(i);
		for(String rstr:recursionresult) {
			myresult.add(chcode + rstr);
		}
		
	}
	return myresult;
}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		ArrayList<String> words = getKPC(str);
		System.out.println(words);
		
		
	}
}
