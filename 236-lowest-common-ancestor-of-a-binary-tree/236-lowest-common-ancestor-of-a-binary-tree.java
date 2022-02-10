/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Map<TreeNode, TreeNode> parentMap = new HashMap(); 
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       
        populateParentMap(null, root);
        
        Set<TreeNode> parentsOfP = new HashSet();
         TreeNode current = p;
        //Find all related parents of p
        while(current != null)
        {
            parentsOfP.add(current);
            current = parentMap.get(current);
        }
        
        current = q; 
        
        while(current != null)
        {
            if(parentsOfP.contains(current))
            {
                return current; 
            }
            
            parentsOfP.add(current);
            current = parentMap.get(current);
        }
        
        return null;  
    }
    
    public void populateParentMap(TreeNode parent, TreeNode root)
    {
        if(root == null)
        {
            return;
        }
        
        if(parent != null)
        {
            parentMap.put(root, parent); 
        }
        
        populateParentMap(root, root.left);
        populateParentMap(root, root.right); 
    }
}