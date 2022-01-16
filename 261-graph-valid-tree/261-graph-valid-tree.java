class Solution {
    Map<Integer, Set<Integer>> graph = new HashMap(); 
    Map<Integer, Set<Integer>> parentMap = new HashMap();
    
    public boolean validTree(int n, int[][] edges) {
        //A tree is valid if : 
        // A child has a single parent, not multiple
        // Every node is conected to some other, not by itself
        Set<Integer> nodes = new HashSet();
        
        if(n == 1 && edges.length == 0)
        {
            return true;
        }
        
        for(int i = 0; i < edges.length; i++)
        {
            int parent = edges[i][0]; 
            int child = edges[i][1];
   
            
            Set<Integer> tmp = graph.getOrDefault(parent, new HashSet());
            tmp.add(child);
            
            graph.put(parent, tmp);
            
            tmp = graph.getOrDefault(child, new HashSet());
            tmp.add(parent);
            
            graph.put(child, tmp); 
            
            
            
            nodes.add(child); 
            nodes.add(parent); 
        }
        
        if(nodes.size() != n)
        {
            return false;
        }
        
        Set<Integer> avoid = new HashSet(); 
        
     
        
        for(int item : graph.keySet())
        {  
            avoid.clear(); 
            int result = nodeCount(-1, item, avoid);
            
            if(result < 0)
            {
                return false;
            }
            
            if(result == n)
            {
                return true;
            }
        }
        
        return false; 
    }
    
    
    
    public int nodeCount(int parent, int node, Set<Integer> avoid)
    {
        if(avoid.contains(node))
        {  
            return -1;
        }
        
        int count = 1;
        avoid.add(node);
        
        if(graph.get(node) != null)
        {            
            for(int item : graph.get(node))
            {
                if(item == parent)
                {
                    continue; 
                }
                int iter = nodeCount(node, item, avoid);
                
                if(iter < 0)
                {
                    return iter; 
                }
                
                count += iter;
            }
        }
        
        return count; 
    }
}