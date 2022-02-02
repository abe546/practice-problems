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
    public boolean isValidBST(TreeNode root) {
        if(root == null)
        {
            return true;
        }
        
        
        return isValidBST(root.left) && 
               isValidBST(root.right) &&
               isLessThanAll(root.right, root.val) &&
               isGreaterThanAll(root.left, root.val);
    }
    
    public boolean isGreaterThanAll(TreeNode root, int value)
    {
        if(root == null)
        {
            return true;
        }
                
        if(value <= root.val)
        { 
            return false;
        }
        
        return isGreaterThanAll(root.left, value) && isGreaterThanAll(root.right, value);
    }
    
    public boolean isLessThanAll(TreeNode root, int value)
    {
        if(root == null)
        {
            return true;
        }
        
        if(value >= root.val)
        {
            return false;
        }
        
        return isLessThanAll(root.left, value) && isLessThanAll(root.right, value); 
    }
}