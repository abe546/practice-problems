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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
        {
            return true; 
        }
        
        if(p == null || q == null)
        {
            return false; 
        }
        
        
        Stack<TreeNode> pStack = new Stack(); 
        Stack<TreeNode> qStack = new Stack();
        
        pStack.add(p); 
        qStack.add(q); 
        
        while(!pStack.isEmpty() && !qStack.isEmpty())
        {
          TreeNode pExamine = pStack.pop(); 
          TreeNode qExamine = qStack.pop(); 
            
          if( pExamine == null && qExamine == null)
        {
            continue;
        }
        
        if(pExamine == null || qExamine == null)
        {
            return false; 
        }
            
        if(pExamine.val != qExamine.val)
        {
            return false; 
        }
            
        pStack.add(pExamine.left);
        pStack.add(pExamine.right); 
        qStack.add(qExamine.left); 
        qStack.add(qExamine.right); 
            
        }
        
        return pStack.isEmpty() && qStack.isEmpty();
    }
}