class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0; 
        int max = 0; 
        int answer = Integer.MIN_VALUE; 
        
        
        
        for(int i = 0; i < nums.length; i++)
        {
            int item = nums[i]; 
            sum += nums[i]; 
            max = Math.max(sum, nums[i]); 
            
            sum = max; 
            
            answer = Math.max(answer, max); 
        }
        
        return answer; 
    }
}