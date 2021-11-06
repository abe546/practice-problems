class Solution {
    public int[] twoSum(int[] nums, int target) {

        for( int i = 0; i < nums.length; i++)
        {
            for( int j = 0; j < nums.length; j++)
            {
                if( i == j)
                {
                    continue; 
                }
                
                if(target == nums[i] + nums[j])
                {
                    int arr[] = {i, j};
                    
                    return arr;
                }
            }
        }
        
        return null; 
        
    }
}