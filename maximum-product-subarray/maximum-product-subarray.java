class Solution {
    public int maxProduct(int[] nums) {
    
        int max = nums[0];
        int sum = 0; 
        for( int i = 0; i < nums.length; i++)
        {
            sum = nums[i]; 
            max = Math.max(sum, max);
            for( int j = i+1; j < nums.length; j++)
            {
                sum *= nums[j]; 
                
                max = Math.max(sum, max);
            }
        }
        
        return max; 
        
    }
}