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
    public int maxDepth(TreeNode root) {

        return findDepth(root, 0);
    }
    
    public int findDepth(TreeNode root, int level)
    {
        if(root == null)
        {
            return level;
        }
        
        level = Math.max(level, Math.max(findDepth(root.left, level+1), findDepth(root.right, level+1)));
        
        return level; 
    }
}