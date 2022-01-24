class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        
        if(intervals == null || intervals.length < 1)
        {
            return true; 
        }
        
        //Is it ok to sort the direct input, without copy, since this is an interview?
        sortArrayOfArrays(intervals);
        
        //Because the input is sorted
        //We know that array entry [i][0] is less than or equal to [j][0] where i < j
        //This simplifies the overlap check, where we can simply say, if 
        //[i][1] (end) is greater than [j][0] we have overlap
 
        
        for(int i =0 ; i < intervals.length -1; i++)
        {
            if(intervals[i][1] > intervals[i+1][0])
            {
                return false; 
            }
        }
        
        return true; 
    }
    
    public void sortArrayOfArrays(int[][] intervals)
    {
        Arrays.sort(intervals, (int[] a, int[] b)
                   -> {
                       return a[0] - b[0];
                   });
    }
}