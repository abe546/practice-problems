class Solution {
    public int search(int[] nums, int target) {
       int index = -1; 
        
        if(nums == null || nums.length == 0)
        {
            return -1; 
        }
        
        if(nums[0] == target)
        {
            return 0;
        }
        
        for(int i = 0; i < nums.length-1; i++)
        {
            if(nums[i] == target)
            {
                return i; 
            }
            
            if(nums[i+1] == target)
            {
                return i+1; 
            }
            
            if(nums[i] > nums[i+1] && nums[i+1] > target)
            {
                return -1;
            }
       
        }
        
        return -1; 
    }
}
