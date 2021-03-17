class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap();
        Set<Integer> uniqueNums = new HashSet();
        PriorityQueue<Integer> queue = new PriorityQueue<>(
            (a,b) ->
            {
                return
                    countMap.getOrDefault(b, 0) - countMap.getOrDefault(a, 0); 
            });
        
        for(int item : nums)
        {
            int count = countMap.getOrDefault(item, 0); 
            
            countMap.put(item, count+1);
            uniqueNums.add(item);
        }
        
        for(int item : uniqueNums)
        {
            queue.add(item);
        }
        
        int[] arr = new int[k];
        int i = 0;
        
        while(i < k && !queue.isEmpty())
        {
            arr[i++] = queue.poll();
        }
        
        return arr;
        
        
    }
}