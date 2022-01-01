package TreeAndLinkedList;

public class IMP_SymmetricTree {

	public static void main(String[] args) {

	}

	class Solution {
		public boolean isSymmetric(TreeNode root) {
			return isSymmetric(root, root);
		}

		public boolean isSymmetric(TreeNode rt1, TreeNode rt2) {
			if (rt1 == null && rt2 == null)
				return true;
			else if (rt1 == null || rt2 == null)
				return false;

			if (rt1.val != rt2.val) {
				return false;
			}
			if (!isSymmetric(rt1.left, rt2.right))
				return false;
			if (!isSymmetric(rt1.right, rt2.left))
				return false;
			return true;
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
