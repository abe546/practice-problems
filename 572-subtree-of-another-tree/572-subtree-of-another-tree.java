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
        
        Queue<TreeNode> possibleParent = new LinkedList(); 
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
              possibleParent.add(current); 
            }
            
            stack.add(current.right); 
            stack.add(current.left); 
        }
        
        for(TreeNode item : possibleParent)
        {
            if(isParent(item, subRoot))
            {
                return true; 
            }
        }
        
        return false; 
    }
    
    public boolean isParent(TreeNode root, TreeNode subRoot)
    {
        if(subRoot == null && root == null)
        {
            return true; 
        }
        
        if(subRoot == null || root == null)
        {
            return false; 
        }
        
        boolean flag = false; 
        
        if(subRoot.val == root.val)
        {
            flag = true;
        }else
        {
            return false;
        }
        
        return flag && isParent(root.left, subRoot.left) && isParent(root.right, subRoot.right); 
    }
     
}