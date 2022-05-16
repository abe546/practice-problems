class MedianFinder {
    
    PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> right = new PriorityQueue<>(); 
    
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        left.add(num); 
        right.add(left.poll()); 
        
        if(left.size() < right.size())
        {
            left.add(right.poll()); 
        }
    }
    
    public double findMedian() {
        int totalSize = left.size() + right.size(); 
        
        if(totalSize % 2 == 0)
        {
            double val1 = left.peek(); 
            double val2 = right.peek(); 
            
            return (val1 + val2)/2;
        }
        
        return (double)left.peek(); 
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */