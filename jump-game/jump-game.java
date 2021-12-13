class Solution {
    
    Map<Integer, Integer> map = new HashMap(); 
    
    public boolean canJump(int[] nums) {
      
        if(nums.length == 1)
        {
            return true;
        }
        
        int limit = nums[0]; 
        int max = nums[0]+1;
        map.put(max, 0); 
        int i = 1; 
        int lastIndex = 0; 
        while(i <= limit){
            
            if(limit >= nums.length-1)
            {
                return true; 
            }
            
            if(max <= nums[i]+(i))
            {
                max = nums[i]+i;
                map.put(max, i);
            }
             
            if(i == limit)
            {
                limit = max;
                i = map.get(max);
                max = 0; 
                
                if(lastIndex == i)
                {
                    return false; 
                }
                
                lastIndex = i; 
            }
            
            i++;
        }
  
        
         
        return false; 
    }
}