class Solution {
    public int missingElement(int[] nums, int k) {
        
        int i = 1;
        int j = nums[0];
        int steps = 0;
        while(j < nums[nums.length-1] && steps < k  )
        { 
            if(j+1 != nums[i]){
                j++;
                steps++;
            }else
            {
                j = nums[i]; 
                i++;
 
               
            }
        }
 
        
        while(steps < k)
        {
            j++;
            steps++; 
        }
        
        return j; 
        }
        
    }
 
