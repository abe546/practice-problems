class Solution {

  public int eraseOverlapIntervals(int[][] intervals) {
      
      //Is it alright to alter input for sake of time?
      sortArrayOfArrays(intervals);
      
      int end = intervals[0][1]; 
      int start = intervals[0][0]; 
      int index = 0; 
      int iter = 1; 
      int remove = 0;
      while(index < intervals.length && iter < intervals.length)
      {
          int[] next = intervals[iter];
          
          if(end > next[0])
          {
              
              
              if(end > next[1])
              {
                  index = iter; 
                  end = next[1];
                 
              }
              iter++;
               remove++;
    
          
          }else
          {
           
              index = iter; 
              end = intervals[index][1];
    iter++;
          }
      }
   
      return remove;
  }
    
    
    public void sortArrayOfArrays(int[][] intervals)
    { 
        Arrays.sort(intervals,
                    (int[] a, int[] b)
                   -> {
                       if(a[0] < b[0])
                       {
                           return -1;
                       }else if(b[0] < a[0])
                       {
                           return 1;
                       }
                       
                       return 0;
                   });
    }
   
}