class Solution {
    public int maxSubArray(int[] nums) {
                
        int max = nums[0];
        int sum = 0; 
        for(int i = 0; i < nums.length; i++)
        {
            sum += nums[i]; 
            
            if(nums[i] >= sum)
            {
                sum = nums[i]; 
            }
            
            max = Math.max(max, sum); 
        }
        
        return max; 
    }
}