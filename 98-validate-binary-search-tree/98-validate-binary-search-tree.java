class Solution {

    public boolean isValidBST(TreeNode root) {
     
        if(root == null)
        {
            return true; 
        }
        
        TreeNode leftGrandParent = null; 
        TreeNode rightGrandParent = null; 
        
        return validate(root, leftGrandParent, rightGrandParent);
    }
    
    public boolean validate(TreeNode root, TreeNode leftGrandParent, TreeNode rightGrandParent)
    {
        if(root == null)
        {
            return true; 
        }
        
        if(leftGrandParent != null && root.val >= leftGrandParent.val)
        {
            return false; 
        }
        
        if(rightGrandParent != null && root.val <= rightGrandParent.val)
        {
            return false; 
        }
        
        return  
            validate(root.left, root, rightGrandParent)
            &&
            validate(root.right, leftGrandParent, root); 
    }
}