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
        
        return findMaxDepth(root, 0); 
    }
    
    public int findMaxDepthIter(TreeNode root, int levelOrigin)
    {
        if(root == null)
        {
            return levelOrigin;
        }
        
        int maxDepth = levelOrigin; 
        
        Map<TreeNode, Integer> nodeToLevel = new HashMap(); 
        
        nodeToLevel.put(root, levelOrigin); 
        
        Stack<Map<TreeNode, Integer>> nodes = new Stack(); 
        
        nodes.push(nodeToLevel); 
        
        while(!nodes.isEmpty())
        {
           Map<TreeNode, Integer> item = nodes.pop(); 
           Map<TreeNode, Integer> child = null;  
            
            TreeNode source = (TreeNode)item.keySet().toArray()[0]; 
            int level = item.get(source); 
            level+=1; 
            
            maxDepth = Math.max(maxDepth, level); 
            
            if(source.left != null)
            {
                child = new HashMap(); 
                child.put(source.left, level ); 
                
                nodes.push(child); 

            }
            
            if(source.right != null)
            {
                child = new HashMap(); 
                child.put(source.right, level ); 
                
                nodes.push(child); 
            }
        }
        
        return maxDepth; 
    }
    
    public int findMaxDepth(TreeNode root, int level)
    {
        if(root == null)
        {
            return level;
        }
        
        return Math.max(findMaxDepth(root.left, level+1), findMaxDepth(root.right, level+1)); 
    }
}