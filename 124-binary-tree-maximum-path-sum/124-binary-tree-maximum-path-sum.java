/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
 
    private int max = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
 
        getMaxPath(root);
        
        return max;
    }
    
    public int getMaxPath(TreeNode root)
    {
        if(root == null)
        {
            return 0;
        }
        
        int current = root.val; 
        
        int leftSum = Math.max(0, getMaxPath(root.left));
        int rightSum = Math.max(0, getMaxPath(root.right));
        
        max = Math.max(max, current + leftSum + rightSum); 
        
        return current + Math.max(leftSum, rightSum); 
    }
    
 
  
}