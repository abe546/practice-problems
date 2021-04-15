class Solution {
    public int lengthOfLIS(int[] nums) {
 
        int[] sub = new int[nums.length];
        
        Arrays.fill(sub, 1);  
        
        for(int i = 0; i < nums.length; i++)
        {
            for(int j = 0; j < i; j++)
            {
                if(nums[j] < nums[i])
                {
                    sub[i] = Math.max(sub[j]+1, sub[i]);
                }
            }
        }
        
        int max = 0; 
        
        for(int item : sub)
        {
            max = Math.max(item, max); 
        }
        
        return max;
        
    }
}