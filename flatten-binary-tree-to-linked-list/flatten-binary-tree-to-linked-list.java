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
    TreeNode list = null;
    TreeNode current = null; 
    
    public void flatten(TreeNode root)
    {
        if(root == null)
        {
            return;
        }
        
        if(root.right == null && root.left == null)
        {
            return; 
        }
        
        traverse(root);
        
        root.right = current.right; 
        root.left = null; 
    }
    
    public void traverse(TreeNode root) {
        
        if(root == null)
        {
            return;
        }
        
        if(list == null)
        {
            list = new TreeNode(root.val); 
            list.left = null; 
            current = list; 
        }
        else
        {
            list.left = null;
            list.right = new TreeNode(root.val);
            list = list.right;
        }
        
        traverse(root.left);
        traverse(root.right); 
     
    }
}