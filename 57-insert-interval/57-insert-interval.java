class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
 
        TreeMap<Integer, Integer> numberLine = new TreeMap(); 
        Set<Integer> numbers = new HashSet(); 
        
        if(intervals.length == 0)
        {
            int[][] arr = new int[1][2];
            arr[0] = newInterval; 
            
            return arr;
        }
        
        int small = Integer.MAX_VALUE;
        int big = intervals[intervals.length-1][1];
        
        for(int[] arr : intervals)
        {
            if(arr[0] > newInterval[1])
            {
                break; 
            }
            
            if(arr[1] < newInterval[0])
            {
                continue; 
            }
            small = Math.min(arr[0], small); 
            for(int i = arr[0]; i <= arr[1]; i++)
            {
            numbers.add(i); 
            numberLine.put(i, i); 
            }
        }
        
        for(int i = newInterval[0]; i <= newInterval[1]; i++)
        {
            numbers.add(i);
             numberLine.put(i, i); 
        }
 
        
        small = Math.min(newInterval[0], small); 
        big = Math.max(newInterval[1], big); 
 
        int start = small; 
        int end = 0;
        
         List<List<Integer>> newIntervals = new LinkedList(); 
         
        while(end < big)
        {
 
            List<Integer> item = new LinkedList();
            
            item.add(start);
            end = start;
            while(numbers.contains(end))
            {
                end++; 
            }
            
            item.add(end-1); 
            
            newIntervals.add(item); 
            
            Integer val = numberLine.ceilingKey(end);
            
            if(val != null)
            {
                end = val;
            }else
            {
                break;
            }
            
            start = end; 
        }
        
        List<List<Integer>> begins = new LinkedList(); 
        
        for(int[] arr : intervals)
        {
            if(arr[0] > newInterval[1])
            {
                List<Integer> tmp = new LinkedList(); 
                tmp.add(arr[0]); 
                tmp.add(arr[1]); 
               newIntervals.add(tmp); 
            }else if(arr[1] < newInterval[0])
            {
                List<Integer> tmp = new LinkedList(); 
                tmp.add(arr[0]); 
                tmp.add(arr[1]); 
               begins.add(tmp); 
            }
        }
        
        begins.addAll(newIntervals); 
        
        newIntervals = begins; 
        
       int[][] arr = new int[newIntervals.size()][2]; 
       int i = 0; 
       for(List<Integer> entry : newIntervals)
       {
           arr[i][0] = entry.get(0); 
           arr[i++][1] = entry.get(1);
       }
        
      return arr;  
        
    }
    
   
}