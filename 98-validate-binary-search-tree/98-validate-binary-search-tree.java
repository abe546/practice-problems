class Solution {

    public boolean isValidBST(TreeNode root) {
     
        if(root == null)
        {
            return true; 
        }
        
        Stack<TreeNode> leftGrandParent = new Stack<>(); 
        Stack<TreeNode> rightGrandParent = new Stack<>(); 
        Stack<TreeNode> stack = new Stack<>(); 
        
        stack.add(root); 
        
        while(!stack.isEmpty())
        {
            TreeNode current = stack.pop(); 
            TreeNode leftAncestor = null; 
            
            if(!leftGrandParent.isEmpty()){
                leftAncestor = leftGrandParent.pop(); 
            } 
            TreeNode rightAncestor = null; 
            
            if(!rightGrandParent.isEmpty())
            {
                rightAncestor = rightGrandParent.pop(); 
            }
            
            if(current == null)
            {
                continue; 
            }
            
            if(leftAncestor != null && current.val >= leftAncestor.val)
            {
                return false; 
            }
            
            if(rightAncestor != null && current.val <= rightAncestor.val)
            {
                return false; 
            }
            
            stack.add(current.right); 
            rightGrandParent.add(current); 
            leftGrandParent.add(leftAncestor); 
            
            stack.add(current.left); 
            rightGrandParent.add(rightAncestor); 
            leftGrandParent.add(current); 
        }
        
        return true; 
    }
  
}