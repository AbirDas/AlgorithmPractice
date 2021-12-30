package Google.Medium;

public class IMP_LowestCommonAncestorOfABinaryTreeII {

	public static void main(String[] args) {

	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || p == null || q == null)
			return null;

		TreeNode value = findLCA(root, p, q);

		if (value == p) {
			return findLCA(p, q, q) != null ? value : null;
		} else if (value == q) {
			return findLCA(q, p, p) != null ? value : null;
		}

		return value;
	}

	public TreeNode findLCA(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q)
			return root;

		TreeNode left = findLCA(root.left, p, q);
		TreeNode right = findLCA(root.right, p, q);

		if (left != null && right != null)
			return root;

		return left != null ? left : right;
	}

	/**
	 * Definition for a binary tree node.
	 */
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

}
