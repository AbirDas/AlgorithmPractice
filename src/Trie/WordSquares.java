package Trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class WordSquares {

	public static void main(String[] args) {
		/*
		Input: words = ["area","lead","wall","lady","ball"]
		Output: [["ball","area","lead","lady"],["wall","area","lead","lady"]]
		Explanation: The output consists of two word squares. The order of output does not matter (just the order of words in each word square matters).
		*/
	}

	class Trie {
		Map<Character, Trie> child;
		List<Integer> wordIndex;

		public Trie() {
			child = new HashMap<>();
			wordIndex = new ArrayList<>();
		}
	}

	int len = 0;
	Trie root = null;

	public List<List<String>> wordSquares(String[] words) {
		root = new Trie();
		len = words[0].length();

		for (int i = 0; i < words.length; i++) {
			Trie curr = root;
			String word = words[i];

			for (char ch : word.toCharArray()) {
				if (!curr.child.containsKey(ch)) {
					curr.child.put(ch, new Trie());
				}
				curr = curr.child.get(ch);
				curr.wordIndex.add(i);
			}
		}

		List<List<String>> ans = new ArrayList<List<String>>();
		for (String word : words) {
			LinkedList<String> wordList = new LinkedList<>();
			wordList.add(word);
			backTrace(1, words, wordList, ans);
		}
		return ans;
	}

	private void backTrace(int step, String[] words, LinkedList<String> wordList, List<List<String>> ans) {
		if (step == len) {
			ans.add((List<String>) wordList.clone());
			return;
		}

		StringBuilder prefix = new StringBuilder();
		for (String str : wordList) {
			prefix.append(str.charAt(step));
		}

		for (Integer itr : getWordFromPrefix(prefix.toString())) {
			wordList.addLast(words[itr]);
			backTrace(step + 1, words, wordList, ans);
			wordList.removeLast();
		}
	}

	private List<Integer> getWordFromPrefix(String prefix) {
		Trie curr = root;
		for (char ch : prefix.toCharArray()) {
			if (curr.child.containsKey(ch)) {
				curr = curr.child.get(ch);
			} else {
				return new ArrayList<Integer>();
			}
		}
		return curr.wordIndex;
	}

}
