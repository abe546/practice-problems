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
        
        int i = 0; 
        int j = 1; 
        int start = intervals[0][0];
        int end = intervals[0][1];
        
        while(i < j && i < intervals.length && j < intervals.length)
        {
            int[] next = intervals[j];
            
            if(end > next[0])
            {
                return false; 
            }else
            {
                end =  intervals[j][1];
                i = j; 
            }
            
            j++;
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