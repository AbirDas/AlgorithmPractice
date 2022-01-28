package Google.Medium;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IMP_LongestStringChain {

	public static void main(String[] args) {
		/*
		Input: words = ["a","b","ba","bca","bda","bdca"]
		Output: 4
		Explanation: One of the longest word chains is ["a","ba","bda","bdca"]
		*/
		String[] words = {"a","b","ba","bca","bda","bdca"};
		System.out.println(longestStrChain(words));
	}

	public static int longestStrChain(String[] words) {
		if (words.length == 1)
			return 1;
		Set<String> container = new HashSet<String>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		Collections.addAll(container, words);

		int maxChain = 0;
		for (String word : words) {
			maxChain = Math.max(maxChain, dfs(word, container, map));
		}
		return maxChain;
	}

	private static int dfs(String word, Set<String> container, Map<String, Integer> map) {
		if (map.containsKey(word))
			return map.get(word);

		StringBuilder sb = new StringBuilder(word);
		int maxWordChain = 1;
		int len = word.length();

		for (int i = 0; i < len; i++) {
			sb.deleteCharAt(i);
			String temp = sb.toString();
			if (container.contains(temp)) {
				maxWordChain = Math.max(maxWordChain, 1 + dfs(temp, container, map));
			}
			sb.insert(i, word.charAt(i));
			map.put(sb.toString(), maxWordChain);
		}
		return maxWordChain;
	}
}
