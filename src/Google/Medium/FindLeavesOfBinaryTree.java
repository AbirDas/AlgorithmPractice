package Google.Medium;

import java.util.ArrayList;
import java.util.List;

public class FindLeavesOfBinaryTree {

	public static void main(String[] args) {

	}

	class Solution {
		List<List<Integer>> answer;

		private Integer findNode(TreeNode root) {
			if (root == null) {
				return -1;
			}

			int left = findNode(root.left);
			int right = findNode(root.right);

			int current = Math.max(left, right) + 1;

			if (this.answer.size() == current) {
				answer.add(new ArrayList<Integer>());
			}

			answer.get(current).add(root.val);

			return current;

		}

		public List<List<Integer>> findLeaves(TreeNode root) {
			if (root == null)
				return null;
			answer = new ArrayList<List<Integer>>();
			findNode(root);
			return answer;
		}
	}

	/**
	 * Definition for a binary tree node.
	 */
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

}
