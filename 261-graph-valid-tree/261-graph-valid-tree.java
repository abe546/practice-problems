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
            
            Set<Integer> avoid = new HashSet();
            if(parentMap.get(child) != null)
            {
                for(int item : parentMap.get(child))
                {
                    avoid.clear();
                    if(related(item, parent, avoid))
                    {
                        return false; 
                    }
                }
            }
            
            if(parentMap.get(parent) != null)
            {
                for(int item : parentMap.get(parent))
                {
                    avoid.clear();
                  if(related(item, child, avoid))
                  {
                      return false; 
                  }
                }
            }
            
            Set<Integer> tmp = graph.getOrDefault(parent, new HashSet());
            tmp.add(child);
            
            graph.put(parent, tmp);
            
            tmp = graph.getOrDefault(child, new HashSet());
            tmp.add(parent);
            
            graph.put(child, tmp); 
            
            tmp = parentMap.getOrDefault(child, new HashSet());
            tmp.add(parent); 
            parentMap.put(child, tmp);
            
            tmp = parentMap.getOrDefault(parent, new HashSet());
            tmp.add(child); 
            parentMap.put(parent, tmp);
            
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
            if(nodeCount(item, avoid) == n)
            {
                return true;
            }
        }
        
        return false; 
    }
    
    public boolean related(int node, int target, Set<Integer> avoid)
    {
        if(avoid.contains(node))
        {
            return false;
        }
        
        avoid.add(node);
        
        if(graph.get(node).contains(target))
        {
            return true; 
        }
        
        for(int item : graph.get(node))
        {
            if(related(item, target, avoid))
            {
                return true; 
            }
        }
      
        return false; 
    }
    
    public int nodeCount(int node, Set<Integer> avoid)
    {
        if(avoid.contains(node))
        {
            return 0;
        }
        
        int count = 1;
        avoid.add(node);
        
        if(graph.get(node) != null)
        {            
            for(int item : graph.get(node))
            {
                count += nodeCount(item, avoid);
            }
        }
        
        return count; 
    }
}