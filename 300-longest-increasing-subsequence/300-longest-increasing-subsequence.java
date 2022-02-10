class Solution {
    public int lengthOfLIS(int[] nums) {
  
        if(nums == null || nums.length == 0)
        {
            return 0;
        }
        
    ArrayList<Integer> frequency = new ArrayList();
    
        for(int i = 0; i < nums.length; i++)
        { 
            frequency.add(1);
         
        }
        
    int max = 1; 
        
    for(int i = 0; i < nums.length; i++)
    {
        int current = nums[i];
        
        for(int j = 0; j < i; j++)
        {
            if(current > nums[j])
            {
                frequency.set(i, Math.max(1 + frequency.get(j), frequency.get(i)));
                max = Math.max(frequency.get(i), max);
            }
        }
    }
        
        return max; 
        
    }
}