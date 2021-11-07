class Solution {
    public int maxProduct(int[] nums) {
     
      int min = nums[0]; 
      int max = nums[0];
      int tmpMax = nums[0]; 
      int finalResult = nums[0];
      
      for(int i=1; i<nums.length;i++)
      {
        int item = nums[i];
        
        tmpMax = Math.max(nums[i], Math.max(item*min, item * max)); 
      
        min = Math.min(nums[i], Math.min(item*min, item*max)); 
    
        max = tmpMax; 
    
        
        finalResult = Math.max(finalResult, max); 
      }
      
      return finalResult; 
    }
}