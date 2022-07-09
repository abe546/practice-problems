
class Solution {
 
    Set<Integer> uniqueNodes = new HashSet(); 
    Map<Integer, Set<ArrayList<Integer>>> graph = new HashMap(); 
    Map<Integer, Integer> distanceFromNode = new HashMap(); 
    public int networkDelayTime(int[][] times, int n, int k) {
  
        // If for some reaosn, by end of problem we only know of n-k (k being 1 or larger)
        
        createGraph(times);
      
         
        // MIN HEAP
        PriorityQueue<ArrayList<Integer>> heap = new PriorityQueue<>(
        (a,b) ->
            {
              return a.get(1) - b.get(1);    
            }
        );
        
        ArrayList<Integer> origin = new ArrayList<>();
        origin.add(k); 
        origin.add(0); 
        
        heap.add(origin); 
        
        int max = 0; 
        
        while(!heap.isEmpty())
        {
            ArrayList<Integer> current = heap.poll(); 
            
            int node = current.get(0); 
            int distance = current.get(1); 
            
            if(distanceFromNode.containsKey(node))
            {
                continue; 
            }
            
            distanceFromNode.put(node, distance); 
            
            max = Math.max(max, distance); 
            
            if(graph.get(node) != null)
            {
                for(ArrayList<Integer> list : graph.get(node))
                {
                    int newNode = list.get(0); 
                    int newDistance = list.get(1) + distance; 
                    
                    if(distanceFromNode.containsKey(newNode))
                    {
                        continue; 
                    }
                    
                    ArrayList<Integer> newEntry = new ArrayList<>(); 
                    
                    newEntry.add(newNode); 
                    newEntry.add(newDistance); 
                    
                    heap.add(newEntry); 
                }
            }
        }
        
        if(distanceFromNode.size() < n)
        {
            return -1; 
        }
        
        return max; 
        
    } 
    
    public void createGraph(int[][] times)
    {
        for(int[] arr : times)
        {
            int source = arr[0]; 
            int dest = arr[1]; 
            int time = arr[2]; 
            
            Set<ArrayList<Integer>> tmp = 
                graph.getOrDefault(source, new HashSet<ArrayList<Integer>>());
            
            ArrayList<Integer> newList = new ArrayList<>(); 
            newList.add(dest); 
            newList.add(time);
            tmp.add(newList); 
            
            graph.put(source, tmp); 
            
            uniqueNodes.add(source); 
            uniqueNodes.add(dest); 
        }
    }
    
   
}