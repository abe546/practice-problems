class Solution {
    public int jump(int[] nums) {
     
        if(nums.length == 1)
        {
            return 0; 
        }
        
         int index = nums[0];    
        int moves = nums[0];
        int move = 1; 
    for(int i = 0; i < nums.length; i++)
    {
       
        if(moves < i)
        {
            moves = index;
            move++; 
        }
   
        
        if(i+nums[i] > index)
        {
            index = i+nums[i]; 
 
        }else
        {
            index = Math.max(index, i); 
  
        }
        
      
        
    
    }
 
        return move;
        
    }
}