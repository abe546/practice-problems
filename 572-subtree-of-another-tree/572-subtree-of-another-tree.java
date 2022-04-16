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
      
       findHead(root, subRoot); 
        
        while(!que.isEmpty())
        {
            if(isSubTree(que.poll(), subRoot))
            {
                return true; 
            }
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
}