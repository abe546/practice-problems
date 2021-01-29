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
    
    private int min = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {

    TreeMap<Integer, Integer> nodes = new TreeMap(); 
    Set<Integer> values = new HashSet(); 
        
    traverse(root, nodes, values);     
        
    for(int item : values)
    {
        Integer key = nodes.ceilingKey(item+1); 
        
        if(key == null)
        {
            continue; 
        }
        
        min = Math.min(Math.abs(key - item), min); 
    }
        
    

     return min; 
    }
    
    public void traverse(TreeNode root, TreeMap<Integer, Integer> nodes, Set<Integer> values)
    {
        if(root == null)
        {
            return;
        }
      
        nodes.put(root.val, root.val); 
        values.add(root.val); 
        
        traverse(root.left, nodes, values); 
        traverse(root.right, nodes, values); 
    }
}