package Array.New;

public class OneEditDistance {

	public static void main(String[] args) {
		/*
		 * 161. One Edit Distance
		 * 
		 * Given two strings s and t, return true if they are both one edit distance
		 * apart, otherwise return false.
		 * 
		 * A string s is said to be one distance apart from a string t if you can:
		 * 
		 * Insert exactly one character into s to get t. Delete exactly one character
		 * from s to get t. Replace exactly one character of s with a different
		 * character to get t.
		 * 
		 * 
		 * Example 1:
		 * 
		 * Input: s = "ab", t = "acb" Output: true Explanation: We can insert 'c' into s
		 * to get t. Example 2:
		 * 
		 * Input: s = "", t = "" Output: false Explanation: We cannot get t from s by
		 * only one step.
		 */

	}
	
	/*
	 * There're 3 possibilities to satisfy one edit distance apart: 
	 * 
	 * 1) Replace 1 char:
	 	  s: a B c
	 	  t: a D c
	 * 2) Delete 1 char from s: 
		  s: a D  b c
		  t: a    b c
	 * 3) Delete 1 char from t
		  s: a   b c
		  t: a D b c
	 */
	public boolean isOneEditDistance(String s, String t) {
		if(s.equals(t)) return false;
		
		for(int i=0; i< Math.min(s.length(), t.length()); i++) {
			if(s.charAt(i)!=t.charAt(i)) {
				if(s.length()==t.length()) {
					return s.substring(i+1).equals(t.substring(i+1));
				} else if (t.length() > s.length()) {
					return s.substring(i).equals(t.substring(i+1));
				} else {
					return t.substring(i).equals(s.substring(i+1));
				}
			}
		}
		return Math.abs(t.length()-s.length()) == 1;
	}

}
