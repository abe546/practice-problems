class Solution {
    public int pivotIndex(int[] nums) {
        
        int totalSum = 0; 
        int sumSoFar = 0; 
        
        for(int item : nums)
        {
            totalSum += item;
        }
        
        int copySum = totalSum;
        
        int index = -1; 
        
        for(int i = 0; i < nums.length; i++)
        {
            copySum -= nums[i]; 
            
            if(copySum == sumSoFar)
            {
                return i;
            }
            
            sumSoFar += nums[i];
            
        }
        
        return index;
    }
}