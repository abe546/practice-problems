class Solution {
    public int combinationSum4(int[] nums, int target) {
      
      Arrays.sort(nums); 
      
      int[] dp = new int[target+1]; 
      dp[0]=1; //We are adding a default value of 1 to the zero dp spot
      //We are told the input is positive numbers (1 to positive infinity)
      
      for(int i=1; i<=target; i++)
      {
        int count =0; 
        for(int j=0; j<nums.length; j++)
        {
          if(nums[j]<=i)
          {
            count+=dp[i-nums[j]];
          }else
          {
            break;
          }
        }
        
        dp[i] = count; 
      }
      
      return dp[target]; 
    }
}