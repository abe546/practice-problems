class Solution {
    public int maxSubArray(int[] nums) {
        
        int currentSum = nums[0]; 
        int finalSum = nums[0];
        
        for(int i = 1; i < nums.length; i++)
        {
            int item = nums[i];
            
            if(currentSum + item < item)
            {
                currentSum = item;
            }else
            {
                currentSum += item; 
            }
            
            finalSum = Math.max(finalSum, currentSum); 
        }
        
        return finalSum; 
    }
}
