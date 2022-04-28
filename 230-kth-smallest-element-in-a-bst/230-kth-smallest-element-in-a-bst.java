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
    public int kthSmallest(TreeNode root, int k) {
      
        int limit = k-1; // Make it 0 indexed
        
        Stack<TreeNode> stack = new Stack<>(); 
        
        TreeNode pointer = root; 
        do{
        while(pointer != null)
        {
            stack.add(pointer);
            pointer = pointer.left; 
        }
        
        TreeNode current = stack.pop(); 
        
        if(limit == 0)
        {
            return current.val;
        }else
        {
            limit--;
            pointer = current.right; 
            
        }
        }while(!stack.isEmpty() || pointer != null);
        
        return root.val; 
    }
    
}