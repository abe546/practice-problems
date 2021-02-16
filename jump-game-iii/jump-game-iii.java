class Solution {
    private Map<Integer, Boolean> cache = new HashMap();
    
    public boolean canReach(int[] arr, int start) {
        
        //Idea is to explore i + arr[i] and i - arr[i] as long as the value is greater
        //than 0 and less than the size of the array
        //We will jump around, and as we do we will take note of the results of the 
        //given index and save it to a map in case we encounter this same value again
        
        return jumpAround(arr, start);
    }
    
    public boolean jumpAround(int[] arr, int start)
    {        
        if(start >= arr.length || start < 0)
        {
            return false;
        }
        
        if(arr[start] == 0)
        { 
            return true; 
        }
         
        if(cache.get(start) != null)
        {
            return cache.get(start); 
        }
        
        int optionA = start + arr[start];
        int optionB = start - arr[start];
       
        if(cache.get(start) == null || cache.get(start) == false)
        {
            cache.put(start, jumpAround(arr, optionA)); 
            
            if(cache.get(start) == false)
            {
                cache.put(start,   jumpAround(arr, optionB)); 
            }
        }
        
        return cache.get(start); 
        
    }
 
}