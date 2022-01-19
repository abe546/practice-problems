class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
     
        
        int[][] copy = new int[intervals.length][intervals[0].length];
        for(int i = 0; i < copy.length; i++)
        {
            copy[i][0] = intervals[i][0];
            copy[i][1] = intervals[i][1];

        }
        
        sortArrOfArrs(copy);
        
        int current = 0; 
        int size =1; 
        while(current < copy.length)
        {
            int[] curr = copy[current];
  
            int end = curr[1];
            current++;
            
            while(current < copy.length)
            {
                int[] next = copy[current];
                    
                if(next[0] >= end){
 
                    end = next[1];
            
                    size++;
                } 
                
                    current++;
            }
        }
        
        return intervals.length - size;
    }
    
    public void sortArrOfArrs(int[][] arr)
    {
        Arrays.sort(arr,
                   (int[] a, int[] b) ->
                    {
                       if(a[1] < b[1])
                       {
                           return -1;
                       }else if(a[1] > b[1])
                       {
                           return 1;
                       }
                        
                        return 0; 
                    });
    }
}