package Google.Medium;

public class IMP_Step_By_StepDirectionsFromABinaryTreeNodeToAnother {

	public static void main(String[] args) {

	}

	public String getDirections(TreeNode root, int startValue, int destValue) {
		if (root == null)
			return "";
		StringBuilder startSB = new StringBuilder();
		StringBuilder endSB = new StringBuilder();
		find(root, startValue, startSB);
		find(root, destValue, endSB);
		int i = 0, j = Math.min(startSB.length(), endSB.length());
		int startLen = startSB.length(), endLen = endSB.length();
		while (i < j && startSB.charAt(startLen - 1 - i) == endSB.charAt(endLen - 1 - i)) {
			i++;
		}

		return "U".repeat(startLen - i) + endSB.reverse().toString().substring(i);
	}

	private boolean find(TreeNode root, int value, StringBuilder sb) {
		if (root.val == value)
			return true;

		if (root.left != null && find(root.left, value, sb)) {
			sb.append("L");
			return true;
		} else if (root.right != null && find(root.right, value, sb)) {
			sb.append("R");
			return true;
		}

		return false;
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
