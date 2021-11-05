package TreeAndLinkedList;
import java.util.ArrayList;
import java.util.List;


public class TreeTraversal {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeTraversal tt = new TreeTraversal();
		TreeNode t = tt.new TreeNode(1,tt.new TreeNode(2),tt.new TreeNode(3));
		List<Integer> answer = tt.inorderTraversal(t);
		
		for(int i:answer) {
			System.out.println(i);
		}
	}
	
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<Integer>();
       if(root == null) return answer;
       if(root.left == null && root.right == null) {
           answer.add(root.val);
           return answer;
       }
       return recursiveSolution(root,answer);
       //return answer;
   }
   int i = 0;
   public List<Integer> recursiveSolution(TreeNode root,List<Integer> answer) {
       if(root == null) return answer;
       
	    recursiveSolution(root.left,answer);
	    answer.add(root.val);
	   //recursiveSolution(root,answer);
        recursiveSolution(root.right,answer);
       return answer;
   }
   
   public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode() {}
	      TreeNode(int val) { this.val = val; }
	      TreeNode(int val, TreeNode left, TreeNode right) {
	          this.val = val;
	          this.left = left;
	          this.right = right;
	      }
	  }

}
