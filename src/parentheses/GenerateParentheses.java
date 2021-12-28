package parentheses;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

	public static void main(String[] args) {
		System.out.println(generateParenthesis(3));
	}

	public static List<String> generateParenthesis(int n) {
		if (n == 0)
			return null;
		List<String> ans = new ArrayList<String>();
		backTracingParenthesis(n, 0, 0, ans, new StringBuilder());
		return ans;
	}

	public static void backTracingParenthesis(int n, int open, int close, List<String> ans, StringBuilder sb) {
		if ((n * 2) == sb.length()) {
			ans.add(sb.toString());
			return;
		}

		if (open < n) {
			sb.append("(");
			backTracingParenthesis(n, open + 1, close, ans, sb);
			sb.deleteCharAt(sb.length() - 1);
		}

		if (close < open) {
			sb.append(")");
			backTracingParenthesis(n, open, close + 1, ans, sb);
			sb.deleteCharAt(sb.length() - 1);
		}
	}

}
