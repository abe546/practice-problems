class Solution {

  public int eraseOverlapIntervals(int[][] intervals) {
  
      //In an interview, ask if its ok, for the sake of item, to alter input
      sortArrayOfArrays(intervals);
      
      int start = intervals[0][0];
      int end = intervals[0][1];
      int count = 0; 
      int index = 0;
      int iter =  1;
 
    for (int i = 1; i < intervals.length; i++) {
      if (intervals[index][1] > intervals[i][0]) {
        if (intervals[index][1] > intervals[i][1]) {
          index = i;
        }
        count++;
      } else {
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