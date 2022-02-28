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
        
        int pathSum = root.val; 
        
        int left = Math.max(getMaxPath(root.left),0);
        int right = Math.max(getMaxPath(root.right),0);
      
        max = Math.max(max, pathSum + left + right);
 
        return pathSum + Math.max(left, right); 
    }
}