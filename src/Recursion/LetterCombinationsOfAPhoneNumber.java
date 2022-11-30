package Recursion;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {
	
	List<String> answer = new LinkedList<String>();
	Map<Character,String> map = Map.of('2',"abc",'3',"def",'4',"ghi",'5',"jkl",'6',"mno",'7',"pqrs",'8',"tuv",'9',"wxyz");
	String digits;
	int len;

	public static void main(String[] args) {
		/*
		Input: digits = "23"
		Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
		 */
		
		LetterCombinationsOfAPhoneNumber l = new LetterCombinationsOfAPhoneNumber();
		System.out.println(l.letterCombinations("23"));
	}
	
	public List<String> letterCombinations(String digits) {
		if(digits==null) return answer;
		len = digits.length();
		this.digits = digits;
		if(len==0) return answer;
		backtracing(0,new StringBuilder());
		return answer;
	}
	
	private void backtracing(int index, StringBuilder sb) {
		if(len==sb.length()) {
			answer.add(sb.toString());
			return;
		}
		
		String curr = map.get(digits.charAt(index));
		for(char ch : curr.toCharArray()) {
			sb.append(ch);
			backtracing(index+1,sb);
			sb.deleteCharAt(sb.length()-1);
		}
	}

}
