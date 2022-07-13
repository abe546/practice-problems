class Solution {
 
    private Map<Integer, Set<Integer>> graph = new HashMap<>();    
    private Set<Integer> cycle = new HashSet<>(); 
    private Map<Integer, Boolean> visited = new HashMap(); 
    public boolean canFinish(int numCourses, int[][] prerequisites) {
 
        
       populateGraph(prerequisites);
         
       for(int node : graph.keySet())
       {
           cycle.clear(); 
           if(allowed(node) != true)
           {
               return false; 
           }
       }
        
       return true;  
    }
    
    public boolean allowed(int node)
    {   
        if(visited.get(node) != null)
        {
            return visited.get(node); 
        }
        
        if(graph.get(node) != null)
        {               
        cycle.add(node); 
        
        for(int child : graph.get(node))
        {
            if(cycle.contains(child))
            { 
                visited.put(node, false); 
                return false; 
            }
            
            if(allowed(child) != true)
            {
                visited.put(node, false); 
                return false; 
            }
        }
        
        cycle.remove(node); 
        }
        visited.put(node, true); 
        return true; 
    }
    
    public void populateGraph(int[][] matrix)
    {
        for(int i = 0; i < matrix.length; i++)
        {
            int source = matrix[i][0];
            int destination = matrix[i][1]; 
            
            Set<Integer> nodes = graph.getOrDefault(source, new HashSet<>());    
            nodes.add(destination); 
            
            graph.put(source, nodes); 
        }
    }
}