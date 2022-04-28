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
       
        TreeNode pointer = root; 
        
        while(pointer != null)
        {
            if(q.val > pointer.val && p.val > pointer.val)
            {
                pointer = pointer.right;
            }else if(q.val < pointer.val && p.val < pointer.val)
            {
                pointer = pointer.left;
            }else
            {
                return pointer; 
            }
        }
        
        return pointer;
        
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