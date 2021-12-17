package string;

import java.util.ArrayList;
import java.util.List;

public class ZigzagConversion {

	public static void main(String[] args) {
		// input PAYPALISHIRING
		//output PAHNAPLSIIGYIR
		System.out.println(convert("PAYPALISHIRING",4));
	}
	
	public static String convert(String s, int numRows) {
		if(s==null) return null;
		int len = s.length();
		if(len<2 || len<numRows || numRows==1) return s;
		StringBuilder answer = new StringBuilder();
		
		List<StringBuilder> list = new ArrayList<StringBuilder>();
		int count = 0;
		boolean direction = false;
		for(int i=0; i<numRows; i++) {
			list.add(new StringBuilder());
		}
		
		for(char c : s.toCharArray()) {
			list.get(count).append(c);
			if(count==0 || count==(numRows-1)) {
				direction = !direction;
			}
			
			count = count + (direction ? 1 : -1);
		}
		
		for(int i=0; i<numRows; i++) {
			answer.append(list.get(i));
		}
		
		return answer.toString();
	}

}
