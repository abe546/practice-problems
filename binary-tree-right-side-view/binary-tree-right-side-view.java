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
    
    public List<Integer> rightSideView(TreeNode root) {      
        if(root == null)
        {
            return Collections.EMPTY_LIST;
        }
        
        List<Integer> levelList = new LinkedList(); 
        Map<Integer, Integer> level = new HashMap(); 
        
        traverse(0, root, level, levelList);
        
        return levelList;
    }
    
    public void traverse(int level, TreeNode root, Map<Integer, Integer> levelMap, List<Integer> levelList)
    {
        if(root == null)
        {
            return;
        }
        
        if(levelMap.get(level) == null)
        {
            levelMap.put(level, root.val);
            levelList.add(root.val);
        }
        
        traverse(level+1, root.right, levelMap, levelList); 
        traverse(level+1, root.left, levelMap, levelList);
    }
}