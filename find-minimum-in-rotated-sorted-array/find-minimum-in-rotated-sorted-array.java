class Solution {
    public int findMin(int[] nums) {
      
      int min = nums[0]; 
        
      for(int item : nums)
      {
          min = Math.min(min, item);
      }
        
        return min; 
    }
}
