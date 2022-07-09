class Solution {
    
    public int[] topKFrequent(int[] nums, int k) {
    
        Map<Integer, Integer> numberToCount = new HashMap(); 
        
        for(int i = 0; i < nums.length; i++)
        {
            int count = numberToCount.getOrDefault(nums[i], 0); 
            count++;
            numberToCount.put(nums[i], count); 
        }
        
        PriorityQueue<Integer> que = new PriorityQueue<>
            ((a,b)
            ->{
               return numberToCount.get(b) - numberToCount.get(a);  
            });
        
        for(int item : numberToCount.keySet())
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