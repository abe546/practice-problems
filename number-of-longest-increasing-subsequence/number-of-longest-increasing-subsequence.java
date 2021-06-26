class Solution {
    public int findNumberOfLIS(int[] nums) {
        
        int[] sequence = new int[nums.length];
        int[] count = new int[nums.length];
        
        //Each item has a default size of 1 (itself)
        Arrays.fill(count, 1); 
        Arrays.fill(sequence, 1); 
        
        int max = 1; 
        
        for(int i = 0; i < nums.length; i++)
        {
            for(int j = 0; j < i; j++)
            {
                if(nums[i] > nums[j])
                {
                    if(sequence[j] == sequence[i] -1)
                    {
                        //Combine count because we know that nums[i] > nums[j]
                        //So if nums[j] is x, 1 before i, then x + count[i] is their total
                        //Sequence count
                        count[i] += count[j]; 
                    }else if(sequence[j] >= sequence[i])
                    {
                        sequence[i] = sequence[j]+1; 
                        count[i] = count[j]; 
                        
                        max = Math.max(max, sequence[i]);
                        
                    }
                }
            }
        }
        
        int answer = 0; 
        
        for(int i = 0; i < sequence.length; i++)
        {
            int item = sequence[i];
            
            if(item == max)
            {
                answer += count[i];
            }
        }
        
        return answer; 
    }
}