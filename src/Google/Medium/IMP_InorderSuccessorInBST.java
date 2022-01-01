package Google.Medium;

public class IMP_InorderSuccessorInBST {

	public static void main(String[] args) {

	}

	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		if(root==null || p==null) return null;
		TreeNode succ = null;
		
		if(p.right!=null) {
			succ = p.right;
			while(succ.left!=null) {
				succ = succ.left;
			}
			return succ;
		}else {
			return findSuccessor(root,p);
		}
		
	}
	
	private TreeNode findSuccessor(TreeNode root, TreeNode p) {
		TreeNode succ = null;
		while(root!=null) {
			if(root.val==p.val) {
				return succ;
			}
			else if(root.val>p.val) {
				succ = root;
				root = root.left;
			}else {
				root = root.right;
			}
		}
		return null;
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
