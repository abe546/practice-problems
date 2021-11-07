class Solution {
    public int maxProduct(int[] nums) {
      
        int sum = nums[0]; 
        int max = nums[0];
        
        for( int i = 0; i < nums.length; i++)
        {
            sum = nums[i]; 

            for( int j = i+1; j < nums.length; j++)
            {
                sum *= nums[j]; 
                max = Math.max(sum, Math.max(nums[j], max));
            }
        }
        
        return max; 
        
    }
}