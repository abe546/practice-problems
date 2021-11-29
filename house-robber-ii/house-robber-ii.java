class Solution {
    public int rob(int[] nums) {
        
        Map<Integer, Set<Integer>> robIndexToNumsIndex = new HashMap(); 
        
        if(nums == null || nums.length == 0)
        {
            return 0;
        }
        
        if(nums.length == 1)
        {
            return nums[0]; 
        }
        
         if(nums.length == 2)
        {
            return Math.max(nums[0], nums[1]); 
        }
        
        if(nums.length == 3)
        {
            return Math.max(nums[0], Math.max(nums[1],nums[2])); 
        }
        
        return Math.max(findHousesToRob(getArr(nums, 0, nums.length-1)), findHousesToRob(getArr(nums, 1, nums.length))); 
        
    }
    
    public int findHousesToRob(int[] nums)
    {   
        
        int[] rob = new int[nums.length];
        
        rob[0] = nums[0]; 
        rob[1] = Math.max(nums[0], nums[1]);
        
        for(int i = 2; i < nums.length; i++)
        { 
            rob[i] = Math.max(rob[i-1], rob[i-2]+nums[i]);
        }
        
        return rob[rob.length-1];
    }
    
    public int[] getArr(int[] nums, int start, int end)
    {
        int[] arr = new int[end - start]; 
        
        int j = start; 
        
        for(int i = 0; i < arr.length; i++)
        {
            arr[i] = nums[j++]; 
        }
        
        return arr; 
    }
}