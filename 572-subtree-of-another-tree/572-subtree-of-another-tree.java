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
 
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        
        if(root == subRoot && root == null)
        {
            return true; 
        }
 
        Stack<TreeNode> stack = new Stack(); 
        stack.add(root); 
        
        while(!stack.isEmpty())
        {
            TreeNode current = stack.pop(); 
            
            if(current == null)
            {
                continue; 
            }
            
            if(current.val == subRoot.val)
            {
            if(isSubTree(current, subRoot))
            {
                return true; 
            }
            }
            
            stack.add(current.right); 
            stack.add(current.left); 
        }
    
        
        return false; 
    }
    
   public boolean isSubTree(TreeNode root, TreeNode subRoot)
    {
        boolean flag = false; 
        
        if(root == null && subRoot == null)
        { 
            flag = true;
            return true; 
        }
        
        if(root != null && subRoot != null && root.val == subRoot.val)
        { 
            flag = true; 
        }
        
        if(flag != true || ((root == null && subRoot != null) || (root != null && subRoot == null)))
        { 
            return false; 
        }
 
        flag = isSubTree(root.left, subRoot.left) && isSubTree(root.right, subRoot.right);
        
        return flag; 
    }
     
}