package Recursion;

import java.util.Stack;

public class ValidateBinarySearchTree {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	//******************** recursion *********************
	public boolean isValidBST_recursion(TreeNode root) {
        return validate(root,null,null);
    }
    
    private boolean validate(TreeNode root, Integer low, Integer high) {
        if(root==null) return true;
        
        if((low!=null && low>=root.val) || (high!=null && high<=root.val)){
            return false;
        }
        
        return (validate(root.left,low,root.val) && validate(root.right,root.val,high));
    }
    //*******************************************************
    
    
    //************************ Iterative *********************
    Stack<TreeNode> stack = new Stack();
    Stack<Integer> lowStack = new Stack();
    Stack<Integer> highStack = new Stack();
    
    private void update(TreeNode root, Integer low, Integer high) {
        stack.push(root);
        lowStack.push(low);
        highStack.push(high);
    }
    
    public boolean isValidBST(TreeNode root) {
        Integer low=null, high=null, val;
        update(root,low,high);
        
        while(!stack.isEmpty()) {
            root = stack.pop();
            low = lowStack.pop();
            high = highStack.pop();
            
            if(root==null) continue;
            val = root.val;
            
            if(low!=null && low>=val){
                return false;
            }
            
            if(high!=null && high<=val) {
                return false;
            }
            
            update(root.left,low,val);
            update(root.right,val,high);
        }
        return true;
    }
    //**************************************************************
}


//Definition for a binary tree node.
class TreeNode {
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
