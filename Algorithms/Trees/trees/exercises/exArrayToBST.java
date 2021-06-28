package trees.exercises;

import tree.BinaryTree;
import tree.BinaryTree.Node;

/**
 * Given an integer array nums where the elements are sorted in ascending order, 
 * convert it to a height-balanced binary search tree.
 * 
 * @author luisa
 * */
public class exArrayToBST {
	
	public static class TreeNode {
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
	public TreeNode  sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length-1);
    }
    
    private TreeNode  buildBST(int[] arr, int start, int end){
        
        if(end < start)
            return null;
        
        int mid = (end+start)/2;
        TreeNode  node = new TreeNode (arr[mid]);
        
        node.left = buildBST(arr, start, mid-1);
        node.right = buildBST(arr, mid+1, end);
        
        return node;
    }
}
