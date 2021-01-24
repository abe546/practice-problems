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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        //Intention is to get the parent of p and q, then check to see what node
        //is the first node where p and q have it as a parent
        
        Map<Integer, TreeNode> parentMap = new HashMap(); 
        
        populateParentMap(root, null, parentMap);
        Set<Integer> parentsOfP = new HashSet(); 
        TreeNode currentP = p;
         
        while(currentP != null)
        {
            parentsOfP.add(currentP.val);  
            
            currentP = parentMap.get(currentP.val); 
        }
        
        TreeNode currentQ = q;
        
        while(currentQ != null)
        {
            if(parentsOfP.contains(currentQ.val))
            {
                return currentQ;
            }
            
            currentQ = parentMap.get(currentQ.val);
            
        }
        
        return null; 
        
    }
    
    public void populateParentMap(TreeNode root, TreeNode parent, Map<Integer, TreeNode> parentMap)
    {
        if(root == null)
        {
            return;
        }
        
