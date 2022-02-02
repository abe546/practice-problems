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
        
         Stack<TreeNode> stack = new Stack();
        stack.add(root);
        
        while(!stack.isEmpty())
        {
            TreeNode current = stack.pop();
            
            if(current == null)
            {
                continue;
            }
            
            //Check left subtree
            List<TreeNode> entries = getSubTree(current.left);
            
            for(TreeNode item : entries)
            {
                if(current.val <= item.val)
                {
                    return false; 
                }
            }
            
            //Check right sub tree
            entries = getSubTree(current.right);
            
            for(TreeNode item : entries)
            {
                if(current.val >= item.val)
                {
                    return false; 
                }
            }
            
            stack.add(current.left);
            stack.add(current.right); 
        }
        
        return true; 
    }
    
    public List<TreeNode> getSubTree(TreeNode root)
    {
        Stack<TreeNode> stack = new Stack();
        
        if(root == null)
        {
            return stack;
        }
        
        List<TreeNode> items = new ArrayList(); 
        
        stack.add(root); 
        
        while(!stack.isEmpty()){
            TreeNode item = stack.pop();
            
            if(item == null)
            {
                continue;
            }
            
            items.add(item);
            stack.add(item.left);
            stack.add(item.right);
        }
        
        return items; 
    }
    
   
}