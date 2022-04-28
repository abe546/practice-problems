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
    Set<TreeNode> set = new HashSet();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if((p.val < root.val && q.val > root.val) || (p.val > root.val && q.val < root.val))
        {
            return root; 
        }
        
        traverse(root, null); 
        
        TreeNode pointer = p;
                
        while(pointer != null)
        {
            set.add(pointer); 
            
            pointer = parentMap.get(pointer); 
        }
        
        pointer = q;
        
        while(pointer != null)
        {
            if(set.contains(pointer))
            {
                return pointer;
            }
            
            pointer = parentMap.get(pointer);
        }
        
        return root;    
    }
    
    public void traverse(TreeNode root, TreeNode parent)
    {
        if(root == null)
        {
            return;
        }
        
        parentMap.put(root, parent); 
        
        traverse(root.left, root); 
        traverse(root.right, root); 
    }
}