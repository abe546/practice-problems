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
    
    private List<Integer> nodes = new LinkedList();
    
    public List<Integer> preorderTraversal(TreeNode root) {
        
        traverse(root); 
        
        return nodes;
    }
    
    public void traverse(TreeNode root)
    {
        if(root == null)
        {
            return;
        }
        
        nodes.add(root.val); 
        traverse(root.left); 
        traverse(root.right); 
    }
}