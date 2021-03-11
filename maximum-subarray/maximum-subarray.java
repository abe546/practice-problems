class Solution {
    public int maxSubArray(int[] nums) {
        
      int currentSum = nums[0]; 
      int finalSum = nums[0]; 
        
        for(int i = 1; i < nums.length; i++)
        {
            currentSum = Math.max(currentSum+nums[i], nums[i]); 
            
            finalSum = Math.max(finalSum, currentSum); 
        }
        
        return finalSum; 
    }
}