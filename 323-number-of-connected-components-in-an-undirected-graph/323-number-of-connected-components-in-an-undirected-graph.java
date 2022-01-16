class Solution {
    
    private Set<Set<Integer>> setOfSets = new HashSet();
    private Set<Integer> nodes = new HashSet();
    private Map<Integer, Set<Integer>> graph = new HashMap();
    private Set<Integer> cache = new HashSet(); 
    
    public int countComponents(int n, int[][] edges) {
        
        if(n == 1 && edges.length == 0)
        {
            return 1;
        }
        
        createGraph(edges); 
                
        for(int node : nodes){
         
        if(cache.contains(node))
        {
           continue; 
        }
            
        Set<Integer> component = new HashSet();
 
        getComponent(node, component);
            
        
        
        setOfSets.add(component); 
        }
 
        
        return setOfSets.size() + (n - nodes.size()); 
    }
    
    public void getComponent(int node, Set<Integer> component)
    {        
        if(component.contains(node))
        {
            return;
        }
        
        component.add(node);
        
        if(graph.get(node) != null)
        {
            for(int item : graph.get(node))
            {
                getComponent(item, component); 
            }
        }
        
        cache.add(node); 
        
    }
    
    public void createGraph(int[][] edges)
    {
        for(int i = 0; i < edges.length; i++)
        {
            int source = edges[i][0];
            int dest = edges[i][1]; 
            
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