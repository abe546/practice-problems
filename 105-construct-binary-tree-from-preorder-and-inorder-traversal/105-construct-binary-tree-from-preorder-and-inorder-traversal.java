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
    TreeMap<Integer, Integer> exist = new TreeMap(); 
    public TreeNode buildTree(int[] preorder, int[] inorder) {
  
        Queue<Integer> que = new LinkedList(); 
        
        for(int i = 0; i < inorder.length; i++)
        {
            inorderIndex.put(inorder[i], i); 
            que.add(preorder[i]); 
        }
        
        return construct(que, inorder);
    }
    
    public TreeNode construct(Queue<Integer> que, int[] inorder)
    {
        Integer current = que.poll(); 
        
        if(current == null)
        {
            return null; 
        }
        
        TreeNode root = new TreeNode(current.intValue()); 
        exist.put(inorderIndex.get(root.val), root.val);
        
        root.left = null;
        root.right = null; 
        
        if(que.peek() != null && canBeLeft(que.peek(), root))
        {
            root.left = construct(que, inorder); 
        }
        
        if(que.peek() != null && canBeRight(que.peek(), root, inorder))
        {
            root.right = construct(que, inorder); 
        }
        
        return root; 
    }
    
    public boolean canBeRight(Integer candidate, TreeNode root, int[] inorder)
    {
        int candidateIndex = inorderIndex.get(candidate.intValue()).intValue(); 
        int rootIndex = inorderIndex.get(root.val).intValue(); 
        
        if(rootIndex > candidateIndex)
        {
            return false; 
        }
        
        Integer nextIndex = exist.ceilingKey(rootIndex+1); 
        
        if(nextIndex != null &&
          nextIndex != candidateIndex && 
          nextIndex < candidateIndex)
        {
            return false; 
        }
        
        return true; 
    }
    
    public boolean canBeLeft(Integer candidate, TreeNode root)
    {
        int candidateIndex = inorderIndex.get(candidate.intValue()).intValue(); 
        int rootIndex = inorderIndex.get(root.val).intValue(); 
        
        if(rootIndex < candidateIndex)
        {
            return false;
        }
        
        return true; 
    }
       
}