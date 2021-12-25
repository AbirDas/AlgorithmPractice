package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

	public static void main(String[] args) {
		String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
		System.out.println(groupAnagrams(strs));
	}

	public static List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> counter = new HashMap<>();

		for (String str : strs) {
			char[] ch = str.toCharArray();
			Arrays.sort(ch);
			String k = String.valueOf(ch);
			if (!counter.containsKey(k)) {
				counter.put(k, new ArrayList<String>());
			}

			counter.get(k).add(str);
		}

		List<List<String>> answer = new ArrayList<List<String>>();

		for (String s : counter.keySet()) {
			answer.add(counter.get(s));
		}

		return answer;
	}

}
