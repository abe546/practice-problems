/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
    //The idea is to merge intervals that coincide with eachothers time line in some way
    //So if [1, 3] exists and there also exists [2,8] we should change this to be [1, 8] as everything is within the same time frame in terms of employee free time
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        
        List<Interval> mergeIntervals = new ArrayList(); 
        
        PriorityQueue<Interval> queue = new PriorityQueue(
            (a,b) ->
            {
                Interval intervalA = (Interval)a;
                Interval intervalB = (Interval)b;
                
               if(intervalA.start != intervalB.start)
               {
                   return intervalA.start - intervalB.start;
               }else
               {
                   return intervalA.end - intervalB.end;
               }
            });
        
        populateQueueWithIntervals(queue, schedule);
        
        if(queue.size() == 1)
        {
            return Arrays.asList(queue.poll()); 
        }
        
        mergeIntervals(mergeIntervals, queue);
        
 
        
        return getGapsInIntervals(mergeIntervals); 
    }
    
    /**
    * If the size of the interval list is 2 or more, return the end and start of each neighbor interval. This represents a gap between intervals (if there was no gap they would have been merged
    in mergeIntervals method)
    **/
    public List<Interval> getGapsInIntervals(List<Interval> mergeIntervals)
    {
        if(mergeIntervals.size() == 1)
        {
            return Collections.EMPTY_LIST;
        }
        
        List<Interval> gaps = new LinkedList(); 
        
        for(int i = 0; i < mergeIntervals.size()-1; i++)
        {
            Interval firstEntry = mergeIntervals.get(i); 
            Interval secondEntry = mergeIntervals.get(i+1); 
            
            gaps.add(new Interval( firstEntry.end, secondEntry.start)); 
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