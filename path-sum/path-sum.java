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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        
        if(root == null)
        {
            return false;
        }
        
        return findPathSum(root, targetSum, 0); 
        
    }
    
    public boolean findPathSum(TreeNode root, int target, int sum)
    {        
        if(root == null)
        {             
            return false; 
        }
        
        
        if(root.right == null && root.left == null)
        {             
            if((sum + root.val) == target)
            {
                return true;
            }
            
            return false; 
        }
         
        return findPathSum(root.left, target, sum+root.val) || findPathSum(root.right, target, sum+root.val);
    }
}