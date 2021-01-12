class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        Map<Integer, Integer> map = new HashMap();
        
        for(int i = 0; i < nums.length; i++)
        {
            int item = nums[i];
            
            map.put(item, i);
        }
        
        for(int i =0 ; i < nums.length; i++)
        {
            int item = nums[i];
            
            if(map.get(target - item) != null && map.get(target - item) != i)
            {
                int[] arr = new int[2];
                arr[0] = i; 
                arr[1] = map.get(target-item);
                return arr;
            }
        }
        
        return null; 
    }
}
