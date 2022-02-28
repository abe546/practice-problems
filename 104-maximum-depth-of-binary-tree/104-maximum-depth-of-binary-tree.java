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
        
 
        Stack<Envelope> stack = new Stack(); 
 
        stack.add(new Envelope(root, ++level));
       
        while(!stack.isEmpty())
        {
            Envelope unpack = stack.pop(); 
            
            if(unpack.item == null)
            {
                continue; 
            }
                        
            int currLevel = unpack.level; 
            TreeNode currNode = unpack.item;
            
            level = Math.max(level, currLevel); 
            
            stack.add(new Envelope(currNode.left, currLevel+1)); 
            stack.add(new Envelope(currNode.right, currLevel+1));             
        }
 
        return level; 
    }
    
    class Envelope 
    {
        TreeNode item;
        int level = 0;
        
        public Envelope(TreeNode item, int level)
        {
            this.item = item;
            this.level = level; 
        }
    }
}