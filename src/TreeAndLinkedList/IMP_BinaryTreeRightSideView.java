package TreeAndLinkedList;

import java.util.ArrayList;
import java.util.List;

public class IMP_BinaryTreeRightSideView {

	public static void main(String[] args) {

	}

	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> ans = new ArrayList<Integer>();
		if (root == null)
			return ans;
		dfs(root, 0, ans);
		return ans;
	}

	private void dfs(TreeNode root, int count, List<Integer> ans) {
		if (root == null)
			return;

		if (count == ans.size()) {
			ans.add(root.val);
		}

		dfs(root.right, count + 1, ans);
		dfs(root.left, count + 1, ans);
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
