class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int[] lengths = new int[nums.length];
        
        //Each subsequence has a length of 1 as max subsequence
        //So set all entries to 1
        Arrays.fill(lengths, 1);
        
        int max = 1; 
        
        for(int i = 0; i < nums.length; i++)
        {
            for(int j = 0; j < i; j++)
            {
                if(nums[j] < nums[i])
                {
                    lengths[i] = Math.max(lengths[i], lengths[j]+1);
                    max = Math.max(max, lengths[i]);
                }
            }
        }
        
        return max; 
    }
}