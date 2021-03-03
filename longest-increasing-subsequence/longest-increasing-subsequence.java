class Solution {
    public int lengthOfLIS(int[] nums) {
 
    int[] subsequence = new int[nums.length]; 
        
    Arrays.fill(subsequence, 1); //Each item occurs at least once
        
    for(int i = 0; i < nums.length; i++)
    {
        for(int j = 0; j < i; j++)
        {
            if(nums[i] > nums[j])
            {
                //+1 to count ourselves
                subsequence[i] = Math.max(subsequence[i], subsequence[j]+1); 
            }
        }
    }
        
    int max = 0; 
        
    for(int item : subsequence)
    {
        max = Math.max(max, item);
    }
        
        return max; 
        
    }
}