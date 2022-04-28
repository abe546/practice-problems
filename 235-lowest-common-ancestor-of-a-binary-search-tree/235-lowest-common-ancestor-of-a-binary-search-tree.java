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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        //Find all parents of each node
     /*   
        Map<Integer, TreeNode> parentsOfP = new HashMap(); 
        Map<Integer, TreeNode> parentsOfQ = new HashMap(); 
        //Assuming BST standard so that all nodes are unique.
        
        findParents(root, p, null, parentsOfP); //null represents the parent of root which is null
        findParents(root, q, null, parentsOfQ); //null represents the parent of root which is null
        
        //Get direct parents of P (including self)
        
            
        TreeNode currP = p;
        TreeNode currQ = q;
        
        Set<Integer> parentsOfPSet = new HashSet(); 
        
        while(currP != null)
        {
            parentsOfPSet.add(currP.val); 
            
            currP = parentsOfP.get(currP.val); 
        }
        
        while(currQ != null)
        {
            if(parentsOfPSet.contains(currQ.val))
            {
                break; 
            }
            
            currQ = parentsOfQ.get(currQ.val); 
        }
    */
        
        int parentVal = root.val;
        
        if(q.val > parentVal && p.val > parentVal)
        {
             return lowestCommonAncestor( root.right, p, q); 
        }else if(q.val < parentVal && p.val < parentVal)
        {
            return lowestCommonAncestor( root.left, p, q); 
        }else
        {
            //At this point root is either equal to p.val or q.val in either case we return current node
            //OR this is the point where there is an inflection and the two nodes will no longer will be in the same subtree
            //So we simply return root as this willbe the last time they share a parent. 
            return root;
        }
        
 
    }
    
    
    
    public void findParents(TreeNode root, TreeNode child, TreeNode parent, Map<Integer, TreeNode> parentsOfChild)
    {
        if(root == null)
        {
            return;
        }
        
        parentsOfChild.put(root.val, parent); 
        
        if(child.val == root.val)
        {
            return;
        }
    
        findParents(root.left, child, root, parentsOfChild);
        findParents(root.right, child, root, parentsOfChild);
    }
}