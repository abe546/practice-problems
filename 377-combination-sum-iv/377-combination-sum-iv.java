class Solution {
    Map<Integer, Integer> map = new HashMap(); 
    public int combinationSum4(int[] nums, int target) {

    return dive(target, nums);    
    }
    
    public int dive(int target, int[] nums)
    {
        if(map.get(target) != null)
        {
            return map.get(target); 
        }
        
        if(target < 0)
        {
            return 0;
        }
        
        if(target == 0)
        {
            return 1;
        }
        int result = 0; 
        for(int i = 0; i < nums.length; i++)
        {
            result+=dive(target-nums[i], nums);
        }
        
        map.put(target, result); 
        
        return result;
    }
}