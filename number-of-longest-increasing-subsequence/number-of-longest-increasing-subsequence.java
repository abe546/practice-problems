class Solution {
    public int findNumberOfLIS(int[] nums) {
        //Use a sequence array to keep track of the longest sequence per iteration
        //Use a count array to count the number of times an 'n' sequence occurs per iter
        //e.g. theres two subsequences that occur of equal size, 
        //count for seq[i] will then be 2
        //By default seq array counts set to 1
        //By default count array counts set to 1
        //Note count[i] represents the max count per iteration
        
        if(nums == null && nums.length == 0)
        {
            return 0;
        }
        
        int[] seq = new int[nums.length];
        int[] count = new int[nums.length];
        
        //Default count is 1 and default seq length is 1
        Arrays.fill(seq, 1);
        Arrays.fill(count, 1);
        
        int maxSeq = 1; 
        
        for(int i = 0; i < nums.length; i++)
        {
            for(int j = 0; j < i; j++)
            {
                if(nums[j] < nums[i])
                {
                    if(seq[j] == seq[i]-1)
                    {
                        count[i] = count[j] + count[i];
                    }else if(seq[j] >= seq[i])
                    {
                        seq[i] = seq[j]+1;
                        count[i] = count[j];
                        
                        maxSeq = Math.max(maxSeq, seq[i]); 
                        
                    }
                }
            }
        }
        
        int answer = 0; 
        
        for(int i = 0; i < seq.length; i++)
        {
            int item = seq[i];
            
            if(item == maxSeq)
            {
                answer += count[i];
            }
        }
        
        return answer; 
    }
}