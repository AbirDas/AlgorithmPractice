package Google.Medium;

import java.util.Stack;

public class IMP_EvaluateReversePolishNotation {

	public static void main(String[] args) {
		/*
		Input: tokens = ["2","1","+","3","*"]
		Output: 9
		Explanation: ((2 + 1) * 3) = 9
		*/
		System.out.println(evalRPN(new String[]{"2","1","+","3","*"}));
	}

	public static int evalRPN(String[] tokens) {
		if (tokens == null)
			return 0;
		Stack<Integer> st = new Stack<Integer>();

		for (String token : tokens) {
			if ("+-*/".contains(token)) {
				int y = st.pop();
				int x = st.pop();

				int ans = 0;
				switch (token) {
				case "+":
					ans = x + y;
					break;
				case "-":
					ans = x - y;
					break;
				case "*":
					ans = x * y;
					break;
				case "/":
					ans = x / y;
					break;
				}
				st.push(ans);
			} else {
				st.push(Integer.valueOf(token));
			}

		}
		return st.pop();
	}

}
