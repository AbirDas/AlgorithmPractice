package Google.Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IMP_DecodeString {

	public static void main(String[] args) {
		//System.out.println(decodeString("3[a]2[bc]"));
		System.out.println(decodeString("100[leetcode]"));
	}

	public static String decodeString(String s) {
		int len = s.length();
		if (len == 1)
			return s;
		Stack<Character> st = new Stack<Character>();
		

		for (int i = 0; i < len; i++) {
			char ch = s.charAt(i);
			if (ch == ']') {
				List<Character> list = new ArrayList<Character>();
				while (!st.isEmpty() && st.peek() != '[') {
					list.add(st.pop());
				}

				st.pop();

				int counter = 0;
				int base = 1;
				while (!st.isEmpty() && Character.isDigit(st.peek())) {
					counter = counter + (st.pop() - '0') * base;
					base *=10;
				}

				while (counter > 0) {
					for (int j = list.size() - 1; j >= 0; j--) {
						st.push(list.get(j));
					}
					counter--;
				}

			} else {
				st.push(ch);
			}
		}

		StringBuilder sb = new StringBuilder();
		while (!st.isEmpty()) {
			sb.append(st.pop());
		}

		return sb.reverse().toString();
	}
}
