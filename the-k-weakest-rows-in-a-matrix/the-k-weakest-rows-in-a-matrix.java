class Solution {
    
    private Map<Integer, Integer> soldiers = new HashMap(); 
    
    public int[] kWeakestRows(int[][] mat, int k) {
        
        for(int i = 0; i < mat.length; i++)
        {
            int soldier = 0; 
            for(int j = 0; j < mat[0].length; j++)
            {
                if(mat[i][j] == 1){
                
                soldiers.put(i, ++soldier); 
                
                }else
                {
                    break;
                }
            }
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) ->
        {
        
            if(soldiers.get(a) == soldiers.get(b))
            {
                return a - b;
            }
            
            return soldiers.getOrDefault(a, 0) - soldiers.getOrDefault(b, 0); 
            
        });
        
        for(int i = 0; i < mat.length; i++)
        {
            queue.add(i); 
        }
        
        int[] arr = new int[k];
        
        int count = 0; 
        int i = 0; 
        while(!queue.isEmpty() && count < k)
        {
            arr[i++] = queue.poll(); 
            count++;
        }
        
        return arr; 
        
    }
}