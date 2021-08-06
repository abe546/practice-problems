class Solution {
    public int lengthOfLIS(int[] nums) {
        
        if(nums == null && nums.length == 0)
        {
            return 0;
        }
        
        //We want to remember the count so far, up to curr index
        int [] count = new int[nums.length];
        //We want to set the greatest frequency up to this index point
        int [] frequency = new int[nums.length];
        
        Arrays.fill(frequency, 1); 
        Arrays.fill(count, 1);
        
        for(int i = 0; i < nums.length; i++)
        {
            for(int j = 0; j < i; j++)
            {
                if(nums[j] < nums[i])
                {   
                    if (frequency[i] > frequency[j])
                    {
                        continue;
                    }
                    else 
                    {
                        count[i] += 1; 
                        frequency[i] = Math.max(frequency[i], frequency[j]+1);
                    }
                }
            }
        }
        
        int max = 0; 
        for(int item : count)
        {
            max = Math.max(item, max); 
        }
        
        return max; 
        
    }
}