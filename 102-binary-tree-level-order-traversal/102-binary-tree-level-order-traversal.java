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
    public List<List<Integer>> levelOrder(TreeNode root) {
    
        Stack<TreeNode> stack = new Stack<>();
        
        Map<Integer, List<Integer>> map = new HashMap(); 
        Map<TreeNode, Integer> levelMap = new HashMap(); 
        
        stack.add(root); 
        levelMap.put(root, 0); 
        int limit = 0; 
        while(!stack.isEmpty())
        {
            TreeNode current = stack.pop(); 
            
            if(current == null)
            {
                continue;
            }
            
            int level = levelMap.get(current);
            
            limit = Math.max(limit, level); 
            
            List<Integer> tmp = map.getOrDefault(level, new ArrayList<Integer>());
            
            tmp.add(current.val);
            
            map.put(level, tmp); 
            
            level++;
            
            stack.add(current.right); 
            stack.add(current.left); 
       
            levelMap.put(current.left, level); 
            levelMap.put(current.right, level); 
 
        }
 
        List<List<Integer>> answer = new LinkedList(); 
        
        for(int i = 0; i <= limit; i++)
        {
            if(map.get(i) != null)
            answer.add(map.get(i)); 
        }
        
        return answer; 
    }
}