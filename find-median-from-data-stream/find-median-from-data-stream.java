class MedianFinder {
 
    PriorityQueue<Integer> lowerBoundMaxQueue = new PriorityQueue<>
        (
        (a,b) -> {
            return b - a;
        });
    
    PriorityQueue<Integer> upperBoundMinQueue = new PriorityQueue();
    
    /** initialize your data structure here. */
    public MedianFinder() {
    
    }
    
    public void addNum(int num) {
  
        lowerBoundMaxQueue.add(num);
        upperBoundMinQueue.add(lowerBoundMaxQueue.poll());
        
        if(lowerBoundMaxQueue.size() < upperBoundMinQueue.size()){
            lowerBoundMaxQueue.add(upperBoundMinQueue.poll()); 
        }
        
    }
    
    public double findMedian() {
      
        int size = upperBoundMinQueue.size() + lowerBoundMaxQueue.size();
        
        if(size % 2 == 0)
        {
            return (double)((double)(upperBoundMinQueue.peek()+lowerBoundMaxQueue.peek())/2);
        }else
        {
            return lowerBoundMaxQueue.peek(); 
        }
        
    }
}
​
/**
 * Your MedianFinder object will be instantiated and called as such:
