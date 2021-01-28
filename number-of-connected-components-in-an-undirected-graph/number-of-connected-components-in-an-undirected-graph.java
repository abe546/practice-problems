class Solution {
    //Create this to account for possible unknown gap nodes
    //E.g. there exists 5 nodes, but the total node count is 10
    //These nodes exist independnet of the graph, and just need to be accounted for
    Set<Integer> allNodes = new HashSet();
    public int countComponents(int n, int[][] edges) {
       
        Map<Integer, List<Integer>> graph = new HashMap();
        
        createGraph(graph, edges); 
        
        Set<Set<Integer>> components = new HashSet(); 
        
        createComponents(components, graph);
        
        int diff = n - allNodes.size(); 
        
        if(diff < 0)
        {
            diff = 0; 
        }
        
        return  components.size()+diff;
    }
    
    public void createComponents(Set<Set<Integer>> components, Map<Integer, List<Integer>> graph)
    {
        //Intention is to get every coupled item as a single 
        //list and it the component list
        
        Set<Integer> innerComponent = new HashSet(); 
        Set<Integer> examined = new HashSet(); 
        
        for(Map.Entry<Integer, List<Integer>> entrySet : graph.entrySet())
        {
            int source = entrySet.getKey(); 
            
            if(examined.contains(source))
            {
                continue; 
            }
       
            
            Stack<Integer> nodes = new Stack(); 
            nodes.add(source);
            innerComponent = new HashSet();
            
            
            while(!nodes.isEmpty())
            {
                for(int innerSource : graph.get(nodes.pop()))
                {
                    if(examined.contains(innerSource))
                    {
                        continue; 
                    }
                    
                    examined.add(innerSource);
                    nodes.push(innerSource);
                    innerComponent.add(innerSource);
                }
            }
            
            components.add(innerComponent); 
        }
    }
    
    public void createGraph(Map<Integer, List<Integer>> graph, int[][] edges)
    {
        for(int [] info : edges)
        {
            int source = info[0];
            int dest = info[1]; 
            
            //Create a link between source and dest
            // (add dest to the list of existing destination nodes, or make a new one
            // and add it)
            List<Integer> container =
                graph.getOrDefault(source, new LinkedList<Integer>()); 
            
            container.add(dest); 
            graph.put(source, container); 
            
            container = graph.getOrDefault(dest, new LinkedList<Integer>()); 
            
            container.add(source); 
            graph.put(dest, container); 
            allNodes.add(source); 
            allNodes.add(dest); 
        }
    }
   
}