class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
   
        Set<Integer> numbers = new HashSet(); 
        
        for(int i = newInterval[0]; i <= newInterval[1]; i++)
        {
            numbers.add(i); 
        }
        
        List<Integer[]> list = new LinkedList();
        int small = Integer.MAX_VALUE;
        int large = Integer.MIN_VALUE;
        int index = intervals.length; 
        for(int i = 0; i < intervals.length; i++)
        {
            Integer[] arr = new Integer[2];
            arr[0] = intervals[i][0];
            arr[1] = intervals[i][1]; 
          
            
            if(arr[0] > newInterval[1])
            {
                  index = i; 
                break; 
            }
            
            if(arr[1] < newInterval[0] )
            {
                list.add(arr);
                continue;
            }
            
            small = Math.min(arr[0], small);
            large = Math.max(arr[1], large);    
 
        }
        
        small = Math.min(small, newInterval[0]); 
        large = Math.max(large, newInterval[1]); 
        Integer[] arr = new Integer[2];
        arr[0] = small;
        arr[1] = large;
        list.add(arr);
        
        for(int i = index; i < intervals.length; i++)
        {
            Integer[] arr2 = new Integer[2];
            arr2[0] = intervals[i][0];
            arr2[1] = intervals[i][1]; 
            
            list.add(arr2); 
        }
        
        int[][] answer = new int[list.size()][2];
        
        int iter = 0; 
        for(Integer[] item : list)
        {
            answer[iter][0] = item[0];
            answer[iter++][1] = item[1];
        }
        
        
        return answer; 
        
        
        
    }
    
   
}