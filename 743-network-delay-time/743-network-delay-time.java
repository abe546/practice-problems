
class Solution {
   
    Map<Integer, Set<ArrayList<Integer>>> graph = new HashMap();
    Set<Integer> nodes = new HashSet(); 
    Set<Integer> avoid = new HashSet(); 
    public int networkDelayTime(int[][] times, int n, int k) {
 
        Comparator<ArrayList<Integer>> customCompare = 
            (a,b) ->
        {
            return a.get(1) - b.get(1);
        };
        
        PriorityQueue<ArrayList<Integer>> que = new PriorityQueue<>(customCompare);
        
        createGraph(times);
        
        //List<Integer> represents x distance from y
        //We are specifically focused on x = k for all 
        ArrayList<Integer> init = new ArrayList();
        init.add(k); 
        init.add(0); 
        que.add(init); 
    
        int max = -1;
 
        while(!que.isEmpty())
        {
            List<Integer> current = que.poll(); 
            
            if(avoid.contains(current.get(0)))
            {
                continue;
            }
            
            avoid.add(current.get(0));
            nodes.add(current.get(0)); 
            if(current.get(1) != 0){
            max = Math.max(current.get(1), max);
            }
 
            if(graph.get(current.get(0)) != null)
            {
                for(ArrayList<Integer> item : graph.get(current.get(0)))
                {
                     
                    item.set(1, item.get(1) + current.get(1));
                    
                    que.add(item);
                }
            }
        }
        
        if(nodes.size() < n)
        {
            return -1; 
        }
        
    return max; 
       
    } 
    
    public void createGraph(int[][] matrix)
    {
        for(int i = 0; i < matrix.length; i++)
        {
            int source = matrix[i][0];
            int dest = matrix[i][1];
            int time = matrix[i][2];
            
            Set<ArrayList<Integer>> tmp = graph.getOrDefault(source, new HashSet<ArrayList<Integer>>());
            
            ArrayList<Integer> item = new ArrayList();
            item.add(dest); 
            item.add(time); 
            
            tmp.add(item);
            graph.put(source, tmp);
 
        }
    }
}