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
    private PriorityQueue<Integer> queue = new PriorityQueue(); 
    public int kthSmallest(TreeNode root, int k) {
        
        traverse(root);
        
        int kSmall = Integer.MAX_VALUE;
        int j = 0;
        
        while(!queue.isEmpty() && j < k)
        {
            kSmall = queue.poll();
           j++;
        }
        
        return kSmall;
    }
    
    public void traverse(TreeNode root)
    {
        if(root == null)
        {
            return;
        }
        
        traverse(root.left);
        traverse(root.right);
        
        queue.add(root.val); 
    }
}