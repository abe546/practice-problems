class Solution {
    public int[][] merge(int[][] copy) {
        
        
        sortArrayOfArrays(copy);
        
        List<List<Integer>> stash = new ArrayList(); 
        
        int current = 0; 
        
        while(current < copy.length)
        {
            int[] item = copy[current];
            int start = item[0];
            int end = item[1];
            current++;
            
            while(current < copy.length)
            {
                int[] next = copy[current];
                
                if((end >= next[0] && end <= next[1]) ||
                   (next[1] >= start && next[1] <= end))
                {
                    start = Math.min(start, next[0]);
                    end = Math.max(end, next[1]);
                    current++;
                }else{
              
                    break; 
                }
            }
            
            List<Integer> tmp = new LinkedList(); 
            tmp.add(start); 
            tmp.add(end); 
            stash.add(tmp); 
        }
        
        int[][] answer = new int[stash.size()][2];
        
        int i =0; 
        for(List<Integer> item : stash)
        {
            answer[i][0] = item.get(0); 
            answer[i++][1] = item.get(1); 
        }
        
        return answer;
    }
    
    public void sortArrayOfArrays(int[][] arr)
    {
        Arrays.sort(arr, 
                    (int[] a, int[] b) ->
                    {
                        if(a[0] < b[0])
                        {
                            return -1;
                        }else if (a[0] > b[0])
                        {
                            return 1;
                        }
                        
                        return 0;
                    });
    }
}