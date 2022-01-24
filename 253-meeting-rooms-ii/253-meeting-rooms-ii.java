class Solution {
    
     class CompareMethod implements Comparator<int[]> {
 
         public int compare(int[] a, int[] b)
         {
             return a[0] - b[0];
         }
     }
    
    public int minMeetingRooms(int[][] intervals) {

        //Is it ok to sort the given data set, since this is an interview
        sortArrayOfArrays(intervals);
        
        PriorityQueue<Integer> que = new PriorityQueue();
        
        que.add(intervals[0][1]); 
        
        for(int i = 1; i < intervals.length; i++)
        {
            if(intervals[i][0] >= que.peek())
            {
                que.poll(); 
            }
            
            que.add(intervals[i][1]);
        }
        
        return que.size(); 
    }
    
    public void sortArrayOfArrays(int[][] intervals)
    {
        Arrays.sort(intervals, new CompareMethod());
    }
    
}
 
    
     