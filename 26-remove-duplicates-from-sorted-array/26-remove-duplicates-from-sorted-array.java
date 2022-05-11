class Solution {
    private static final int SKIP = 101; // Problem states array values are between -100 and 100 inclusive
    public int removeDuplicates(int[] nums) {
        
        Set<Integer> set = new HashSet();
        
        for(int i = 0; i < nums.length; i++)
        {
          if(set.contains(nums[i]))
          {
              nums[i] = SKIP;
          }else {
              set.add(nums[i]);
          }
        }
        
        int count = 0; 
        
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] == SKIP){
                for(int j = i; j < nums.length; j++)
                {
                    if(nums[j] != SKIP)
                    {
                        int tmp = nums[j];
                        nums[j] = nums[i];
                        nums[i] = tmp;
                        break;
                    }
                }
                
                // If not changed break
                if(nums[i] == SKIP)
                {
                    break;
                }
                count++;
            }else{
                count++;
            }
        }
        
        return count;
    }
}