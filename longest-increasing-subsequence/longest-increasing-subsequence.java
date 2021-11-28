class Solution {
    public int lengthOfLIS(int[] nums) {
 
        int[] sequence = new int[nums.length];
        
        Arrays.fill(sequence, 1); 
        int max = 1; 
        
        for(int i = 0; i < nums.length; i++)
        {
            for(int j = 0; j < i; j++)
            {
                if(nums[j] < nums[i])
                {
                    sequence[i] = Math.max(sequence[i], sequence[j]+1);
                    max = Math.max(sequence[i], max);
                }
            }
        }
        
        return max; 
        
    }
}