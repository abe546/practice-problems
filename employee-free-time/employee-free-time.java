        }
        
        return gaps; 
    }
    
    /**
    * Merge any intervals that are a part of eahc other; e.g the end of either interval is contianerd within the other
    */
    public void mergeIntervals(List<Interval> mergeIntervals, PriorityQueue<Interval> queue)
    {
        Interval origin = queue.poll(); 
        
        while(!queue.isEmpty())
        {
            Interval tmp = queue.poll();  
            
            int start = origin.start; 
            int end = origin.end;
            int otherStart = tmp.start;
            int otherEnd = tmp.end; 
            
            if( (end >= otherStart && end <= otherEnd) || (otherEnd >= start && otherEnd <= end) )
            {
                int newStart = Math.min(start, otherStart); 
                int newEnd = Math.max(end, otherEnd); 
                
                origin.start = newStart; 
                origin.end = newEnd;
            }else
            {
                Interval clone = new Interval(origin.start, origin.end); 
                
                mergeIntervals.add(clone); 
                
                origin.start = tmp.start; 
                origin.end = tmp.end; 
            }
            
            if(queue.isEmpty())
            {
                mergeIntervals.add(origin); 
            }
        }
    }
    
    public void populateQueueWithIntervals(PriorityQueue<Interval> queue, List<List<Interval>> schedule)
    {
        for(List<Interval> innerList : schedule)
        {
            for(Interval interval : innerList)
            {
                queue.add(interval); 
            }
        }
    }
}
