class Solution {
    public int findNumberOfLIS(int[] nums) {
      
        if(nums == null || nums.length == 0)
        {
            return 0; 
        }
        
        int max = 1; 
        int[] frequency = new int[nums.length];
        int[] count = new int[nums.length];
        
        Arrays.fill(frequency, 1); 
        Arrays.fill(count, 1); 
        
        for(int i = 0; i < nums.length; i++)
        {
            for(int j = 0; j < i; j++)
            {
                
                
                if(nums[j] < nums[i])
                {
                    if(frequency[i] - 1 == frequency[j])
                    {
                    count[i] += count[j]; 
                    continue;
                    }else if( frequency[j] >= frequency[i]){
                    
                    frequency[i] = Math.max(frequency[i], frequency[j] + 1);
                    count[i] = count[j]; 
                    max = Math.max(frequency[i], max);                    
                }
            }
        }
        }
        
        int answer = 0; 
        for(int i = 0; i < count.length; i++)
        {
            int item = frequency[i]; 
            
            if(item == max)
            {
                answer+=count[i]; 
            }
        }
        
        return answer;
        
    }
}