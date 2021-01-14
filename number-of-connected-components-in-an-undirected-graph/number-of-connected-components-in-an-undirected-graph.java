            allNodes.add(source); 
            allNodes.add(dest); 
        }
        
       Set<Set<Integer>> components = new HashSet(); 
        
        createComponents(components, graph); 
        
        int missingNodes = n - allNodes.size(); 
        
        if(missingNodes < 0)
        {
            missingNodes = 0; 
        }
        
        System.out.println("GRAPH : "+graph); 
        System.out.println("COMPONENTS : "+components); 
        return components.size() + missingNodes; 
    }
    
    public void createComponents(Set<Set<Integer>> components, Map<Integer, List<Integer>> graph)
    {
        Set<Integer> seen = new HashSet(); 
        for(int node : graph.keySet())
        {
            if(!seen.contains(node))
            {
                Set<Integer> innerComponent = new HashSet(); 
                Stack<Integer> nodes = new Stack(); 
                
