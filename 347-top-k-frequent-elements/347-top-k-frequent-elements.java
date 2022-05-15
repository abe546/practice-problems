class Solution {
    
    private Set<Integer> uniqueItems = new HashSet(); 
    public int[] topKFrequent(int[] nums, int k) {
    
        Map<Integer, Integer> numberCount = new HashMap(); 
        
        populateMap(numberCount, nums);
        
        // MAX Heap
        PriorityQueue<Integer> heap = 
            new PriorityQueue<>(
        (a,b) ->
            {
                int aValue = numberCount.get(a).intValue(); 
                int bValue = numberCount.get(b).intValue(); 
          
                if(aValue > bValue)
                {
                    return -1;
                }else if(bValue > aValue)
                {
                    return 1;
                }
                
                return 0;
                
            }
        );
        
        for(int item : uniqueItems)
        {
            heap.add(item); 
        }
        
        int[] answer = new int[k]; 
        int i = 0; 
        while(!heap.isEmpty() && i < k){
        answer[i++] = heap.poll(); 
        }
        
        return answer; 
    }
    
    public void populateMap(Map<Integer, Integer> numberCount, int[] nums)
    {
        for(int i = 0; i < nums.length; i++)
        {
            int count = numberCount.getOrDefault(nums[i], 0).intValue();
            count++; 
            
            numberCount.put(nums[i], count); 
            
            uniqueItems.add(nums[i]); 
        }
    }
}