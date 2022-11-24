package Queue_Stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int evalRPN(String[] tokens) {
		if (tokens == null)
			return 0;
		Stack<Integer> stack = new Stack<Integer>();

		for (String token : tokens) {

			if (!"*/+-".contains(token)) {
				stack.push(Integer.valueOf(token));
				continue;
			}

			int v2 = stack.pop();
			int v1 = stack.pop();
			int result = 0;

			switch (token) {
			case "+":
				result = v1 + v2;
				break;
			case "-":
				result = v1 - v2;
				break;
			case "*":
				result = v1 * v2;
				break;
			case "/":
				result = v1 / v2;
				break;
			}
			stack.push(result);
		}

		return stack.pop();
	}

}
