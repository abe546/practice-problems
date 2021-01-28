class Solution {
    public int lastStoneWeight(int[] stones) {
     //MAX HEAP
     PriorityQueue<Integer> queue = new PriorityQueue(Collections.reverseOrder());         
     for(int item : stones)
     {
         queue.add(item);
     }
        
     while(queue.size() > 1)
     {
         int first = queue.poll(); 
         int second = queue.poll(); 
         
         queue.add(Math.abs(first-second)); 
     }
        
     if(queue.isEmpty())
     {
         return 0;
     }
        
    return queue.poll(); 
        
    }
}