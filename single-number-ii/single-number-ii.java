class Solution {
    public int singleNumber(int[] nums) {
                
        Map<Integer, Integer> numbersToCount = new HashMap(); 
    
        for(int item : nums)
        {
            numbersToCount.put(item, numbersToCount.getOrDefault(item, 0)+1);
        }
        
        for(Map.Entry<Integer, Integer> entrySet : numbersToCount.entrySet())
        {
            if(entrySet.getValue() == 1)
            {
                return entrySet.getKey(); 
            }
        }
 
        return 0;
    }
}