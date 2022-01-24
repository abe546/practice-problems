class Solution {

  public int eraseOverlapIntervals(int[][] intervals) {
  
      //In an interview, ask if its ok, for the sake of item, to alter input
      sortArrayOfArrays(intervals);
      
      int start = intervals[0][0];
      int end = intervals[0][1];
      int count = 0; 
      int index = 0;
      int iter =  1;
     
      for(int i = 1; i < intervals.length; i++)
      {
           int[] next = intervals[i];
          
          if(intervals[index][1] > next[0])
          {
              if(next[1] < intervals[index][1])
              {
                  index = i;
                  end = intervals[index][1];
              }
              count++;
          }else
          {
              index = i; 
          }
      }
      
      return count; 
      
  }
    
    
    public void sortArrayOfArrays(int[][] intervals)
    {
        Arrays.sort(intervals,
                   (int[] a, int[] b)
                   ->{
                      return a[0] - b[0]; 
                   });
    }
   
}