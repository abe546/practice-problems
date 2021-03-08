class Solution {
    public boolean canJump(int[] nums) {
 
    int index = nums[0];    
        
    for(int i = 0; i <= index; i++)
    {
        if(index >= nums.length -1)
        {
            return true; 
        }
        
        if(i+nums[i] > index)
        {
            index = i+nums[i]; 
        }else
        {
            index = Math.max(index, i); 
        }
    }
        
        System.out.println("INDEX : "+index);
        
        return false;
        
    }
}