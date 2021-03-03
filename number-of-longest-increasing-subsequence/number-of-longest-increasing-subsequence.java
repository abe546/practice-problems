class Solution {
    public int findNumberOfLIS(int[] nums) {
 
    int[] subsequence = new int[nums.length]; 
    int[] count = new int[nums.length];
    Arrays.fill(subsequence, 1); 
    Arrays.fill(count, 1); 

    int max = 1; 
        
    for(int i = 0; i < nums.length; i++)
    {
        for(int j = 0; j < i; j++)
        {
          if(nums[i] > nums[j])
          {
              if(subsequence[j] >= subsequence[i])
              {
                  subsequence[i] = Math.max(subsequence[i], subsequence[j]+1);
                  count[i] = count[j]; 
                  max = Math.max(subsequence[i], max); 
              }else if(subsequence[j] == subsequence[i] -1)
              {
                  count[i] += count[j];
              } 
          }
        }
    }
  
        int answer = 0; 
        
        for(int i = 0; i < subsequence.length; i++)
        {
            int item = subsequence[i];
            
            if(item == max)
            {
                answer += count[i];
            }
        }
        
        
    return answer; 
 
        
    }
}