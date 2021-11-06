class Solution {
    
    Set<Integer> hashSet = new HashSet();
    
    public boolean containsDuplicate(int[] nums) {
        
        for(int item : nums)
        {
            if(hashSet.contains(item))
            {
                return true; 
            }
            
            hashSet.add(item);
        }
        
        return false; 
    }
}