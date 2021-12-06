package TreeAndLinkedList;

public class BinaryTreeMaximumPathSum {

	//Main logic
	int maxValue;
	public int maxPathSum(TreeNode root) {
		maxValue = Integer.MIN_VALUE;
		pathSum(root);
		return maxValue;
	}

	public int pathSum(TreeNode node) {
		if (node == null)
			return 0;
		int left = pathSum(node.left);
		int right = pathSum(node.right);

		int maxPath = Math.max(Math.max(left, right) + node.val, node.val);
		int maxNode = Math.max(maxPath, left + right + node.val);
		maxValue = Math.max(maxValue, maxNode);

		return maxPath;
	}
	
	// Definition for a binary tree node.
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
