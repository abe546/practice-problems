class Solution {
    Map<Integer, Set<Integer>> graph = new HashMap(); 
    Set<Integer> nodes = new HashSet(); 
    Map<Integer, Integer> cache = new HashMap();
    
    public boolean validTree(int n, int[][] edges) {
    
        if(n == 1 && edges.length == 0)
        {
            return true; 
        }
        
        createGraph(edges);
        
        if(nodes.size() != n)
        {
            return false; 
        }
        
        Set<Integer> avoid = new HashSet();
        
        for(int item : nodes)
        {
            avoid.clear(); 
            int count = nodeCount(-1, item, avoid);
            
            if(count == n)
            {
                return true;
            }
            
            if(count < 0)
            {
                return false; 
            }
        }
        
    return false;
    }
    
    public int nodeCount(int parent, int node, Set<Integer> avoid)
    {
        if(cache.containsKey(node))
        {
            return cache.get(node);
        }
        
        if(avoid.contains(node))
        {
            cache.put(node, -1);
            return -1;
        }
        
        avoid.add(node);
        int count = 1; 
        if(graph.get(node) != null)
        {
            for(int item : graph.get(node))
            {
                if(item == parent)
                {
                    continue;
                }
                
                int result = nodeCount(node, item, avoid);
                
                if(result < 0)
                {
                    cache.put(node, result); 
                    //Cycle detected
                    return result;
                }
                
                count += result;
            }
        }
        
        cache.put(node, count); 
        return count; 
    }
    
    public void createGraph(int[][] matrix)
    {
        for(int i = 0; i < matrix.length; i++)
        {
            int source = matrix[i][0]; 
            int dest = matrix[i][1]; 
            
            Set<Integer> tmp = graph.getOrDefault(source, new HashSet());
            tmp.add(dest); 
            graph.put(source, tmp); 
            
            tmp = graph.getOrDefault(dest, new HashSet());
            tmp.add(source); 
            graph.put(dest, tmp); 
            
            nodes.add(source); 
            nodes.add(dest); 
            
        }
    }
}