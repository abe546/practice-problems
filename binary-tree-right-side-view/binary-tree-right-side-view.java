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
     List<Integer> nodes = new LinkedList(); 
    Map<Integer, TreeNode> seen = new HashMap(); 
    public List<Integer> rightSideView(TreeNode root) {
        
        traverse(root, 0); 
        
        return nodes; 
    }
    
     public void traverse(TreeNode root, int level)
     {
         if(root == null)
         {
             return;
         }
         
         if(seen.get(level) == null)
         {
             seen.put(level, root); 
             nodes.add(root.val); 
         }
         
         traverse(root.right, level+1); 
         traverse(root.left, level+1); 
     }
}