package Trie;

import java.util.HashMap;
import java.util.Map;

public class MaximumXOROfTwoNumbersInAnArray {

	public static void main(String[] args) {
		/*
		Input: nums = [3,10,5,25,2,8]
		Output: 28
		Explanation: The maximum result is 5 XOR 25 = 28.
		*/
	}

	class Trie {
		Map<Character, Trie> child;

		public Trie() {
			child = new HashMap<>();
		}
	}

	public int findMaximumXOR(int[] nums) {
		int maxLen = 0;
		for (int num : nums) maxLen = Math.max(maxLen, num);
		int l = (Integer.toBinaryString(maxLen)).length();

		int len = nums.length, bitLen = 1 << l;
		String[] strs = new String[len];
		for (int i = 0; i < len; i++) {
			strs[i] = Integer.toBinaryString(bitLen | nums[i]).substring(1);
		}

		int maxXOR = 0;
		Trie root = new Trie();

		for (String str : strs) {
			int currXOR = 0;
			Trie curr = root, xor = root;

			for (char bit : str.toCharArray()) {
				if (!curr.child.containsKey(bit)) {
					Trie next = new Trie();
					curr.child.put(bit, next);
				}
				curr = curr.child.get(bit);

				char toggle = bit == '1' ? '0' : '1';
				if (xor.child.containsKey(toggle)) {
					currXOR = (currXOR << 1) | 1;
					xor = xor.child.get(toggle);
				} else {
					currXOR = currXOR << 1;
					xor = xor.child.get(bit);
				}
			}
			maxXOR = Math.max(maxXOR, currXOR);
		}
		return maxXOR;
	}

}
