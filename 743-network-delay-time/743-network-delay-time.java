class Solution {
    Map<Integer, Set<ArrayList<Integer>>> graph = new HashMap<>(); 
    Set<Integer> nodes = new HashSet<>(); 
    Map<Integer, Integer> minDistance = new HashMap<>(); 
    
    public int networkDelayTime(int[][] times, int n, int k) {
        // Create the graph in a map
        // Create the heap
        // Then allocate K as start node, then explore
        
        createGraph(times);
        
        // Min queue based on time of points
        PriorityQueue<ArrayList<Integer>> que = new PriorityQueue<>(
        (a,b) ->
            {
                return a.get(1) - b.get(1); 
            }
        );
        
        // Place source node
        ArrayList<Integer> source = new ArrayList<>(); 
        source.add(k); 
        source.add(0); 
        int max = -1; 
        
        que.add(source); 
        while(!que.isEmpty())
        {
            ArrayList<Integer> pair = que.poll(); 
            int node = pair.get(0); 
            int time = pair.get(1); 
            
            if(minDistance.containsKey(node))
            {
                continue;
            }
            
            minDistance.put(node, time); 
            
            if(time != 0 && max < time)
            {
                max = time; 
            }
            
            if(graph.get(node) != null)
            {
                for(ArrayList<Integer> item : graph.get(node))
                {
                    int newNode = item.get(0); 
                    int newTime = item.get(1) + time;
                    if(!minDistance.containsKey(newNode)){
                        ArrayList<Integer> newItem = new ArrayList<>(); 
                        
                        newItem.add(newNode); 
                        newItem.add(newTime); 
                        
                        que.add(newItem); 
                    }
                }
            }
        }
      
        if(minDistance.size() != n)
        {
            return -1; 
        }
        
        return max; 
        
    }
    
    // Create graph, and note ALL nodes (to and from)
    public void createGraph(int[][] matrix)
    {
        for(int i = 0; i < matrix.length; i++)
        { 
            int start = matrix[i][0];
            int target = matrix[i][1];
            int time = matrix[i][2];
            
            Set<ArrayList<Integer>> tmp = 
                graph.getOrDefault(start, new HashSet<>());
            
            ArrayList<Integer> tmpList = new ArrayList<>();
            
            tmpList.add(target); 
            tmpList.add(time); 
            
            tmp.add(tmpList); 
            
            graph.put(start, tmp); 
            nodes.add(start); 
            nodes.add(target); 
 
        }
    }
}