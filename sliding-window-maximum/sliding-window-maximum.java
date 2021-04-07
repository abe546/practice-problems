class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        Deque<Integer> window = new ArrayDeque(); 
        List<Integer> maxList = new LinkedList(); 
        int max = 0; 
        
        int j = 0; 
        while(j < nums.length && j < k){
          keepMax(window, j, j-k, nums); 
          j++;
        }
        
        
        maxList.add(nums[window.getFirst()]); 
        
        for(int i = k; i < nums.length; i++)
        {
            keepMax(window, i, i-k, nums); 
            maxList.add(nums[window.getFirst()]); 
        }
        
        int[] answer = new int[maxList.size()];
        
        j = 0; 
        
        for(int item : maxList)
        {
            answer[j++] = item;
        }
        
        return answer; 
        
    }
    
    public void keepMax(Deque<Integer> deque, int index, int limit, int[] nums)
    {
        if(!deque.isEmpty() && deque.getFirst() == limit)
        {
            deque.removeFirst(); 
        }
        
        while(!deque.isEmpty() && nums[deque.getLast()] < nums[index])
        {
            deque.removeLast();
        }
        
        deque.addLast(index);
    }
}