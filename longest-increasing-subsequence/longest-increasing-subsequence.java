class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int[] sub = new int[nums.length]; 
        
        //Each number occurrs atleast once itself
        Arrays.fill(sub, 1); 
        
        int max = 1; 
        
        for(int i = 0; i < nums.length; i++)
        {
            for(int j = 0; j < i; j++)
            {
                if(nums[j] < nums[i])
                {
                    sub[i] = Math.max(sub[i], sub[j]+1);
                }
                
                max = Math.max(sub[i], max);
            }
        }
        
        return max; 
    }
}