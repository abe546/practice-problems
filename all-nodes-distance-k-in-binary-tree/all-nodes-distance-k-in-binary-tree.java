/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        
      
        
        //Print out nodes distance K away
        List<Integer> nodes = new LinkedList(); 
    
        
        
        Map<Integer, TreeNode> nodeToParent = new HashMap(); 
        
        findNodesBelowTargetIterative(target, K, nodes, 0); 
        populateParentsOfNodes(root, null, nodeToParent);
        
        //When target is root no need for looking above
        if(target.val != root.val)
        {
        findNodesAboveTarget(root, target, nodeToParent, K, nodes);
        }
       
        
        return nodes; 
    }
    
    /*
    * Find nodes above targt that are K (limit) away. Idea is to continually call the parentMap and decrement limit
      once limit = 0 add the node, if we encounter a parent as null that means we then need to call 
      findNodesBelowTarget with the input being root and the limit being the new decremented limit
    */
    public void findNodesAboveTarget(TreeNode root, TreeNode target, Map<Integer, TreeNode> nodeToParent, int limit, List<Integer> list)
    {
        TreeNode currentNode = nodeToParent.get(target.val); 
        int newLimit = limit-1; 
        Set<Integer> encountered = new HashSet(); 
