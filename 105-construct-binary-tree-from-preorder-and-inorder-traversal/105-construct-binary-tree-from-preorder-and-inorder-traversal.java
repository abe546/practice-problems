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
 
    HashMap<Integer, Integer> inorderIndex = new HashMap(); 
    Queue<Integer> nodes = new LinkedList(); 
    TreeMap<Integer, Integer> exist = new TreeMap(); 
    private int[] inOrder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        inOrder = new int[inorder.length];
        for(int i = 0; i < inorder.length; i++)
        {
            inorderIndex.put(inorder[i], i); 
            nodes.add(preorder[i]); 
            inOrder[i] = inorder[i]; 
            
        }
        
        TreeNode root = construct(nodes);
 
        
        return root; 
    }
    
   
    
    public TreeNode construct(Queue<Integer> que)
    {
        Integer current = que.poll(); 
        
        if(current == null)
        {
            return null; 
        }
        
        exist.put(inorderIndex.get(current), inorderIndex.get(current)); 
        
        TreeNode root = new TreeNode(current);
        
        root.left = null; 
        root.right = null; 
        
        if(!que.isEmpty() && canBeLeftChild(root, que.peek()))
        {
            root.left = construct(que); 
        }
        
        if(!que.isEmpty() && canBeRightChild(root, que.peek()))
        {
            root.right = construct(que); 
        }
        
        return root; 
    
    }
    
    public boolean canBeLeftChild(TreeNode root, Integer candidate)
    {
        if(inorderIndex.get(root.val) < inorderIndex.get(candidate))
        {
            return false; 
        }
        
        return true; 
    }
    
    public boolean canBeRightChild(TreeNode root, Integer candidate)
    {
        if(inorderIndex.get(root.val) > inorderIndex.get(candidate))
        {
            return false; 
        }
  
        Integer index = exist.ceilingKey(inorderIndex.get(root.val)+1);
 
        if(index != null){
             Integer item = inOrder[index]; 
 
            if(item != null && item != candidate &&
               index <
               inorderIndex.get(candidate))
            {        
 
                return false; 
            }
        }
        
        return true; 
    }
    
 
}