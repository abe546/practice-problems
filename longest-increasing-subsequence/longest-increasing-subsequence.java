class Solution {
    public int lengthOfLIS(int[] nums) {
 
        if(nums == null || nums.length == 0)
        {
          return 0; 
        }
 
        int[] memory = new int[nums.length]; 
        
        memory[0] = 1;  
        
        for(int i = 1; i < nums.length; i++)
        {
            int myMemory = 0;
            
            for(int j = 0; j < i; j++)
            {
                if(nums[i] > nums[j])
                {
                    myMemory = Math.max(memory[j], myMemory);
                }
            }
            
            memory[i] = myMemory + 1; //The 1 represents self 
        }
        
        int max = 0; 
        
        for(int item : memory)
        {
            max = Math.max(item, max); 
        }
        
        return max;
    }
}