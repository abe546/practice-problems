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
    
        Queue<Integer> nodes = new LinkedList(); 
        
        for(int i = 0; i < inorder.length; i++)
        {
            inorderIndex.put(inorder[i], i); 
            nodes.add(preorder[i]); 
        }
        
        return construct(nodes, inorder);
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
        
        if(canBeLeftChild(que.peek(), root, inorder))
        {
            root.left = construct(que, inorder);
        }
        
        if(canBeRightChild(que.peek(), root, inorder))
        {
            root.right = construct(que, inorder);
        }
        
        return root; 
    }
    
    public boolean canBeLeftChild(Integer candidate, TreeNode root, int[] inorder)
    {
        if(candidate == null)
        {
            return false; 
        }
        
        int rootIndex = inorderIndex.get(root.val); 
        int candidateIndex = inorderIndex.get(candidate.intValue());
        
        if(candidateIndex > rootIndex)
        {
            return false; 
        }
        
        
        return true; 
    }
    
    public boolean canBeRightChild(Integer candidate, TreeNode root, int[] inorder)
    {
         if(candidate == null)
        {
            return false; 
        }
        
        int rootIndex = inorderIndex.get(root.val); 
        int candidateIndex = inorderIndex.get(candidate.intValue()); 
        
        if(rootIndex > candidateIndex)
        {
            return false; 
        }
        
        Integer indexOfNext = exist.ceilingKey(rootIndex+1);
        
        if(indexOfNext != null && indexOfNext != candidateIndex && indexOfNext < candidateIndex)
        {
            //System.out.println(String.format("root %s cand %s exist %s", root.val, candidateIndex, indexOfNext)); 
            return false; 
        }
        
     
        return true; 
    }
}