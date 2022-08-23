class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> uniqueNums = new HashSet<>();
        for(int i = 0; i < nums.length; i++)
        {
            int count = map.getOrDefault(nums[i], 0);
            count++;
            map.put(nums[i], count);
            uniqueNums.add(nums[i]); 
        }
        
        PriorityQueue<Integer> que = new PriorityQueue<>(
        (a,b) ->
            {
                if(map.get(a) > map.get(b))
                {
                    return -1;
                }else if(map.get(b) > map.get(a))
                {
                    return 1;
                }
                
                return 0; 
            }
        );
        
        for(int item : uniqueNums)
        {
            que.add(item); 
        }
        
        int[] arr = new int[k];
        
        for(int i = 0; i < k; i++)
        {
            arr[i] = que.poll();
        }
        
        return arr; 
    }
}