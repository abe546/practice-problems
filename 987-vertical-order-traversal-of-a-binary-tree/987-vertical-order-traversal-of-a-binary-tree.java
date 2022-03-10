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
    Map<Integer, List<TreeNode>> map = new HashMap();
    Map<TreeNode, Integer> nodeToRow = new HashMap(); 
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        traverse(root, 0, 0);
        
        List<List<Integer>> answer = new ArrayList(); 
        Set<Integer> sortedKeys = new TreeSet(map.keySet());
        for(int col : sortedKeys)
        {
            List<TreeNode> tmp = map.get(col);
            
            Collections.sort(tmp, (a,b) ->
                             {
                                 int diff = nodeToRow.get(a).intValue() - nodeToRow.get(b).intValue();
                                 
                                 if(diff == 0)
                                 {
                                     return a.val - b.val;
                                 }
                                 
                                 return diff;
                             });
           List<Integer> nodeValues = new ArrayList();
            for(TreeNode node : tmp)
            {
                nodeValues.add(node.val);
            }
            
            answer.add(nodeValues); 
        }
        
        return answer; 
    }
    
    public void traverse(TreeNode root, int row, int col)
    {
        if(root == null)
        {
            return;
        }
        nodeToRow.put(root, row);
        List<TreeNode> tmp = map.getOrDefault(col, new ArrayList<TreeNode>());
        
        tmp.add(root);
        
        map.put(col, tmp);
        
        traverse(root.left, row+1, col-1);
        traverse(root.right, row+1, col+1);
    }
}