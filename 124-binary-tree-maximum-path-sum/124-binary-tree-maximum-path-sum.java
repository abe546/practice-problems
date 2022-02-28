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
        
        int leftPath = Math.max(getMaxPath(root.left), 0);
        int rightPath = Math.max(getMaxPath(root.right), 0);
        
        //We take max possible at current level of pseudo root + left child + right child
        max = Math.max(max, current + leftPath + rightPath); 
        
        return current + Math.max(leftPath, rightPath); 
    }
    
  
}