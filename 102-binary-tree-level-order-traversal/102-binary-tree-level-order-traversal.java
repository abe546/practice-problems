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
    public List<List<Integer>> levelOrder(TreeNode root) {
        TreeNode heightItem = root;
        int height = findHeight(heightItem);
        
        List<List<Integer>> list = new LinkedList();

        for(int i=0; i<height;i++)
        {
            LinkedList<Integer> singleList = new LinkedList();
            printLevel(root,i, singleList);
            
            list.add(singleList);
        }
        
        return list;
    }
    
    public Integer printLevel(TreeNode root, int level, List list)
    {
        if(root == null)
        {
            return null;
        }
        
        if(level == 0)
        {
            list.add(root.val);
            return root.val;
        }
        
        if(level>0)
        {
            printLevel(root.left, level-1, list);
            printLevel(root.right, level-1, list);
        }
        
        return null;
    }
    
    public int findHeight(TreeNode root)
    {
        if(root == null)
        {
            return 0;
        }
        
        if(root.right == null && root.left == null)
        {
            return 1;
        }
        
        int sizeLeft = 1+findHeight(root.left);
        int sizeRight = 1+findHeight(root.right);
        
        if(sizeRight > sizeLeft)
        {
            return sizeRight;
        }
        
        return sizeLeft;
    }
}