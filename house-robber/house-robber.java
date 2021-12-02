class Solution {
    public int rob(int[] nums) {
  
        
        if(nums.length == 1)
        {
            return nums[0];
        }
        
        if(nums.length == 2)
        {
            return Math.max(nums[0], nums[1]);
        }
        
       int[] arr = new int[nums.length];
        
        arr[0] = nums[0]; 
        arr[1] = nums[1]; 
        
        for(int i = 0; i < nums.length; i++)
        {
            if(i == 0){
            arr[i] = nums[i];
            }else if(i == 1)
            {
                arr[i] = Math.max(nums[i], arr[i-1]); 
                
            }else{
            arr[i] = Math.max(nums[i] + arr[i-2], arr[i-1]);
            }
        }
        
        return arr[arr.length-1];
        
    }
 
}