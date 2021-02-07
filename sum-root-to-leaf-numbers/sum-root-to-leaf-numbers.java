import java.math.BigInteger; 

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
    private BigInteger sum = new BigInteger("0"); 
    public int sumNumbers(TreeNode root) {
        
        traverse(root, ""); 
        
        return sum.intValue();
    }
    
    public void traverse(TreeNode root, String item)
    {
        if(root == null)
        {
            return;
        }
        
        if(root.right == null && root.left == null)
        { 
            String appendString = item+String.valueOf(root.val); 
         
            sum = sum.add(new BigInteger(appendString)); 
   
            return;
        }
        
        traverse(root.left, item+String.valueOf(root.val));
        traverse(root.right, item+String.valueOf(root.val));
    }
}