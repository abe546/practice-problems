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
    private  TreeNode list = new TreeNode(0);
    public void flatten(TreeNode root) {
        
        if(root == null)
        {
            return;
        }
       list.left = null; 
        TreeNode head = list; 
        
        traverse(root);
        
        TreeNode current = head.right.right; 
        
        while(current != null)
        { 
             
            root.right = current;
            root.left = null; 
            
            root = root.right; 
            current = current.right;
        }
        
  
    }
    
    public void traverse(TreeNode root)
    {
        if(root == null)
        {
            return;
        }
        
        TreeNode newNode = new TreeNode(root.val); 
 
        list.right = newNode;
        list = list.right;
        list.left = null; 
        
        traverse(root.left); 
        traverse(root.right);
    }
}