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
                return 
                    numberCount.get(b).intValue()
                    - 
                    numberCount.get(a).intValue();
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