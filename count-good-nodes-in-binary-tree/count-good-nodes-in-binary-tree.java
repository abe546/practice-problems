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
    //Representative of the last action performed
    public int goodNodes(TreeNode root) {
    
    if(root == null)
    {
        return 0; 
    }
    
        return traverse(root, root.val);
    }
    
    int traverse(TreeNode root, int max){
        if(root == null){
            return 0;
        }
        
        if(root.val < max){
            
            return traverse(root.left,max) + traverse(root.right,max);
        }
        
        max = root.val;    
        return traverse(root.left,max) + traverse(root.right,max) + 1;
 
    }
    
    
}