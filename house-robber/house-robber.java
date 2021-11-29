class Solution {
    public int rob(int[] nums) {
        
        int[] rob = new int[nums.length]; 
        
        if(nums == null || nums.length == 0)
        {
            return 0; 
        }
        
        if(nums.length == 1)
        {
            return nums[0]; 
        }
     
        
        return findHousesToRob(nums); 
        
    }
    
    public int findHousesToRob(int[] nums)
    { 
        int[] rob = new int[nums.length];
        
        rob[0] = nums[0]; 
        rob[1] = Math.max(nums[1], nums[0]);
 
        
        for(int i = 2; i < nums.length; i++)
        { 
             
    
            rob[i] = Math.max(rob[i-1], rob[i-2]+nums[i]);
        }
        
        return rob[rob.length-1]; 
    }
}