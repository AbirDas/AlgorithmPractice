package string;

import java.util.Arrays;

public class Amazon_PasswordStrengthUniqueLetterString {

	public static void main(String[] args) {
		System.out.println(uniqueLetterStringCount("ABC"));
	}
	
	public static long uniqueLetterStringCount(String password) {
		if(password==null) return 0;
		int len = password.length();
		if(len==1) return 1;
		
		long sum = 0, count = 0;
		
		int[] last = new int[26];
		int[] pre = new int[26];
		
		Arrays.fill(last, -1);
		Arrays.fill(pre, -1);
		
		for(int i=0; i<len; i++) {
			char c = password.charAt(i);
			//count = count + q - r + 1
			// where
			// q = i - lastIndex - 1 (no of last count doesn't contains c/s[i]
			// r = lastIndex - preIndex (no of last count which contain exactly once c/s[i]
			count += (i - last[c-'A'] - 1) - (last[c-'A']-pre[c-'A']) + 1;
			sum += count;
			
			//update index
			pre[c-'A'] = last[c-'A'];
			last[c-'A'] = i;
		}
		return sum;
	}

}
