package Trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordSearchII {

	public static void main(String[] args) {
		/*
		Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
		Output: ["eat","oath"]
		*/
	}

	class Trie {
		Map<Character, Trie> child;
		String val;

		public Trie() {
			child = new HashMap<>();
			val = null;
		}
	}

	public List<String> findWords(char[][] board, String[] words) {
		List<String> ans = new ArrayList<>();
		Trie root = new Trie();

		for (String word : words) {
			Trie curr = root;
			for (char ch : word.toCharArray()) {
				if (!curr.child.containsKey(ch)) {
					Trie next = new Trie();
					curr.child.put(ch, next);
				}
				curr = curr.child.get(ch);
			}
			curr.val = word;
		}

		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[0].length; col++) {
				Trie curr = root;
				char ch = board[row][col];
				if (curr.child.containsKey(ch)) {
					// findWords(board,row,col,curr.child.get(ch),ans);
					findWords(board, row, col, curr, ans);
				}
			}
		}
		return ans;
	}

	private void findWords(char[][] board, int row, int col, Trie root, List<String> ans) {

		char ch = board[row][col];
		Trie node = root.child.get(ch);

		if (node.val != null) {
			ans.add(node.val);
			node.val = null;
		}

		board[row][col] = '#';

		int[][] direction = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		for (int[] dir : direction) {
			int newRow = row + dir[0];
			int newCol = col + dir[1];

			if (newRow < 0 || newRow >= board.length || newCol < 0 || newCol >= board[0].length)
				continue;

			if (node.child.containsKey(board[newRow][newCol])) {
				findWords(board, newRow, newCol, node, ans);
			}
		}
		board[row][col] = ch;

		// Optimization: incrementally remove the leaf nodes
		if (node.child.isEmpty()) {
			root.child.remove(ch);
		}
	}

}
