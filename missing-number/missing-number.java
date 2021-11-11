class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int item = 0; 
        for(int i = 0; i < nums.length; i++)
        { 
            
            if(i != nums[i])
            {
                return i;
            }
            
            item = i; 
            
           
        }
        
        return item+1; 
    }
}