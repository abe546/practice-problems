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
   Queue<TreeNode> que = new LinkedList(); 
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        
        if(root == subRoot && root == null)
        {
            return true; 
        }
  
        
        findHead(root, subRoot); 
    
         while(!que.isEmpty())
        {
            if(isParent(que.poll(), subRoot))
            {
                return true; 
            }
        }
        
        return false; 
    }
    
    public void findHead(TreeNode root, TreeNode target)
    {        
        if(root == null)
        {
            return;
        }
        
         if(target.val == root.val)
        { 
            que.add(root); 
        }
        
       findHead(root.left, target); 
  
        findHead(root.right, target); 
 
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