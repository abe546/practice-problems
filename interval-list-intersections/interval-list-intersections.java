class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        
        List<int[]> intervals = new LinkedList();
        
        int i = 0; 
        int j = 0; 
        
        for(int[] intervals2 : firstList){
        j = 0;              
        while(j < secondList.length)
        { 
            int[] interval1 = intervals2;
            int[] interval2 = secondList[j]; 
            
            if((interval1[0] >= interval2[0] && interval1[0] <= interval2[1])
               ||
               (interval2[0] >= interval1[0] && interval2[0] <= interval1[1]))
            {
                int x = Math.max(interval1[0], interval2[0]);
                int y = Math.min(interval1[1], interval2[1]); 
                
                int[] arr = {x, y}; 
                
                intervals.add(arr);
                j++; 
            }else if((interval1[1] >= interval2[0]  &&
                      interval1[1] <= interval2[1]) 
                     ||
                    (interval2[1] >= interval1[0] && 
                     interval2[1] <= interval1[1]))
            {
                int x = Math.min(interval1[1], interval2[1]); 
                
                int[] arr = {x, x}; 
                
                intervals.add(arr);
                j++; 
            }
            else
            {
                j++;
            }
        }
            
        }
        
        int[][] answer = new int[intervals.size()][2]; 
        
        for(int k = 0; k < intervals.size(); k++)
        {
            answer[k][0] = intervals.get(k)[0];
            answer[k][1] = intervals.get(k)[1];
        }
        
        return answer;
    }
}