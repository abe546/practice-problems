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
        
        int[] arr = new int[nums.length-1];
        int[] arr2 = new int[nums.length-1];
        
        int max = -1; 
 
            arr[0] = nums[0];
            arr[1] = Math.max(nums[1], arr[0]);
            
        for(int i = 2; i < nums.length-1; i++)
        {
            arr[i] = Math.max(nums[i]+arr[i-2], arr[i-1]);
        }
 
            arr2[0] = nums[1];
            arr2[1] = Math.max(nums[2], arr2[0]);
            
        for(int i = 3; i < nums.length; i++)
        {
            arr2[i-1] = Math.max(nums[i]+arr2[i-3], arr2[i-2]);
        }
   
       max = Math.max(arr[arr.length-1], arr2[arr2.length-1]); 
       

        return max;
    }
    
}