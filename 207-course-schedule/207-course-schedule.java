class Solution {
    
    private     Map<Integer, Boolean> map = new HashMap(); 
    private List<Integer> list = new LinkedList(); 
    public boolean canFinish(int numCourses, int[][] prerequisites) {
     
    Map<Integer, Set<Integer>> graph = new HashMap();  
    Set<Integer> memory = new HashSet<Integer>();
        

        
    createGraph(graph, prerequisites);
        
        for(int[] items : prerequisites)
        {
            list.clear(); 
            if(!allowed(items[0], memory, graph)){
                return false; 
            }
            
            System.out.println("LIST : "+list); 
        }
    
    return true;     
    }
    
    public boolean allowed(int node, Set<Integer> memory, Map<Integer, Set<Integer>> graph)
    {
        if(map.get(node) != null)
        {
            return map.get(node); 
        }
        
        if(memory.contains(node))
        {
            return false; 
        }
        
        if(graph.get(node) == null)
        {
            //no children
            return true; 
        }
        
        memory.add(node); 
        
        for(int child : graph.get(node))
        {
            if(!allowed(child, memory, graph))
            {
                return false; 
            }
        }
  
 
        map.put(node, true);
        
        return true; 
    }
    
    public void createGraph(Map<Integer, Set<Integer>> graph, int[][] prereqs)
    {
        for(int i = 0; i < prereqs.length; i++)
        {
            //Given preres[0-n].length == 2
            int from = prereqs[i][0];
            int to = prereqs[i][1]; 
            
            Set<Integer> tmp = graph.getOrDefault(from, new HashSet<Integer>());
            tmp.add(to); 
            
            graph.put(from, tmp); 
        }
    }
}