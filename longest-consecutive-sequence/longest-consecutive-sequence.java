class Solution {
    public int longestConsecutive(int[] nums) {
      
      if(nums == null || nums.length == 0)
      {
          return 0; 
      }
        
      int max = 0; 
      int count = 1; 
        
      Arrays.sort(nums); 
        
      for(int i = 0; i < nums.length-1; i++)
      {
          if(nums[i] == nums[i+1] - 1)
          {
              count++;
          }else if(nums[i] == nums[i+1])
          {
              continue;
          }else {
              max = Math.max(count, max); 
              count = 1; 
          }
      }
        
      max = Math.max(count, max); 
      
        
      return max; 
    }
}