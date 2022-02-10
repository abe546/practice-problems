class Solution {
    public int lengthOfLIS(int[] nums) {
  
   
        
    ArrayList<Integer> frequency = new ArrayList();
    
        for(int i = 0; i < nums.length; i++)
        { 
            frequency.add(1);
         
        }
        
    int max = 1; 
        
    for(int i = 0; i < nums.length; i++)
    {
        int current = nums[i];
        
        for(int j = i+1; j < nums.length; j++)
        {
            if(current < nums[j])
            {
                frequency.set(j, Math.max(1 + frequency.get(i), frequency.get(j)));
                max = Math.max(frequency.get(j), max);
            }
        }
    }
        
        return max; 
        
    }
}