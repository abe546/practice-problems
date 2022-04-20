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
    Set<Integer> exist = new HashSet(); 
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        for(int i = 0; i < inorder.length; i++)
        {
            inorderIndex.put(inorder[i], i); 
            nodes.add(preorder[i]); 
        }
        
        TreeNode root = construct(nodes);
        
        preorder(root);
        
        return root; 
    }
    
    public void preorder(TreeNode root)
    {
        if(root == null)
        {
            return;
        }
        
        Integer left = null; 
        Integer right = null; 
        
        if(root.left != null)
        {
            left = root.left.val;
        }
        
        if(root.right != null)
        {
            right = root.right.val; 
        }
        
        System.out.println(
        String.format("root:%s l:%s r:%s", root.val, left, right)
        );
  
        preorder(root.left); 
        preorder(root.right); 
    }
    
    public TreeNode construct(Queue<Integer> que)
    {
        Integer current = que.poll(); 
        
        if(current == null)
        {
            return null; 
        }
        
        exist.add(current); 
        
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
        
        for(int item : exist)
        {
            if(inorderIndex.get(item) > inorderIndex.get(root.val) &&
               inorderIndex.get(item) < inorderIndex.get(candidate))
            {
                return false; 
            }
        }
        
        return true; 
    }
    
 
}