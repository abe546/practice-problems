class Solution {
 
    public int maxProfit(int[] prices) {
        
      int localMinimum = prices[0]; 
      int localMaximum = prices[0]; 
      int i = 0; 
      int max = 0; 
       while(i < prices.length - 1)
       {
           while(i < prices.length - 1 && prices[i] >= prices[i+1])
           {
               i++;
           }
           
           localMinimum = prices[i]; 
           
           while(i < prices.length - 1 && prices[i] <= prices[i+1])
           {
               i++;
           }
           
           localMaximum = prices[i];
           
           max += localMaximum - localMinimum;
       }
        
        return max; 
    }
    
   
    
    
    /** TLE EXCEPTION
    
    
    private     int max = 0;
    private Map<Integer, Integer> cache = new HashMap(); 
    public int maxProfit(int[] prices) {
        
     
        
        int min = Integer.MAX_VALUE; 
        for(int i = 0; i < prices.length; i++){
         
        min = prices[i]; 
        
        findMax(min, 0, i+1, prices);
    
        }
        
        return max; 
    }
    
    public void findMax(int min, int maxSoFar, int index, int[] prices)
    {
        if(cache.get(index) != null)
        {
            max = Math.max(max, cache.get(index));
            return;
        }
        
        if(index >= prices.length)
        {
            max = Math.max(maxSoFar, max); 
 
            return;
        }
        
        for(int i = index; i < prices.length; i++)
        {
            if(min >= prices[i])
            {
                min = prices[i]; 
                continue;
            }
            
            findMax(min, maxSoFar, i+1, prices); 
            maxSoFar += prices[i] - min; 
            min = Integer.MAX_VALUE; 
        }
        
        max = Math.max(max, maxSoFar); 
 
    }
    
    
    
    */
}