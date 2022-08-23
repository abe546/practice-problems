class Solution {
    public int lengthOfLIS(int[] nums) {
  
        int[] frequency = new int[nums.length];
        
        Arrays.fill(frequency, 1);
        int max = 1;
        for(int i = 0; i < nums.length; i++)
        {
            for(int j = i+1; j < nums.length; j++)
            {
                if(nums[j] > nums[i])
                {
                    frequency[j] = Math.max(1+frequency[i], frequency[j]);
                    max = Math.max(max, frequency[j]);
                }
            }
        }
        
        return max; 
    }
}