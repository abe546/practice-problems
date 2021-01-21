/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
      
      if(root == null)
      {
        return true; 
      }
      
       
      return traverse(root, root); 
      
    }
  
  public boolean traverse(TreeNode root0, TreeNode root)
  {
    if(root0 == null && root == null)
    {
      return true;
    }
    
    if(root0 == null || root == null)
    {
      return false; 
    }
    
    boolean same = false; 
    
    if(root0.val == root.val )
    {
      same = true;
    }
    
    return same && traverse(root.right, root0.left) && traverse(root.left, root0.right); 
  }
  
   
}
