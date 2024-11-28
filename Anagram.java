/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
			str2 = preProcess(str2);
			str1 =  preProcess(str1);
			for(int i = 0; i <str1.length();i++){
				char curChar = str1.charAt(i);
				int index = -1;
				for(int t = 0; t < str2.length(); t++){
					if (curChar == ' ') break;
					index = str2.indexOf(curChar,index +1);
					if (index == -1 && t ==0) {
						return false;					
					}else if (index == -1){
						if (str1.indexOf(curChar, i+1 )== -1) {
							return false;	
						}
					}
					break;
				}
		}
		
		

		return true;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String yes = "abcdefghijklmnopqrstuvwxyz " ; 
		String temp = str.toLowerCase();
		String newstr = "";
		for (int i = 0; i < temp.length(); i++) {
			if (yes.indexOf(temp.charAt(i)) > -1) {
				newstr += temp.charAt(i);				
			}
		}   
          return newstr;

			}

	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String ana = "";
		String temp = preProcess(str);
		for (int i = 0; i < str.length(); i++){
			int rand = (int) (Math.random()*temp.length());
			ana += temp.charAt(rand);
			temp = temp.substring(0, rand) + temp.substring(rand + 1);
			
		}

	 	

		return ana;
	}
}
