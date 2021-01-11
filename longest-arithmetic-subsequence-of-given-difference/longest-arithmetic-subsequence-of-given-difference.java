class Solution {
    public int longestSubsequence(int[] arr, int difference) {
    Map<Integer, Integer> seen = new HashMap(); 
        int max = 0;
        for(int i = 0 ; i < arr.length; i++)
        {
            int item = arr[i]; 
            
            if(seen.get(item-difference) != null)
            {
                seen.put(item, seen.get(item-difference)+1);    
            }
            
            if(seen.get(item) == null)
            {
                seen.put(item, 1); 
            }
          
            
            max = Math.max(seen.get(item), max); 
      
        }
        
        return max; 
}
}
