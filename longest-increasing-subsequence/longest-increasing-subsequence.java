class Solution {
    public int lengthOfLIS(int[] nums) {
      
      if(nums == null || nums.length == 0)
      {
        return 0; 
      }
      
      int[] dp = new int[nums.length]; 
      dp[0]=1;
      
      int max =1; 
 
      for(int i=1; i<nums.length; i++)
      { 
        int count =0; 
        for(int j=0; j<i;j++)
        { 
          if(nums[j]<nums[i])
          {      
            count = Math.max(count, dp[j]); 
          }
        }
        
        count++; 
        dp[i] = count; 
        max = Math.max(dp[i], max); 
      }
    
      return max; 
    }
}