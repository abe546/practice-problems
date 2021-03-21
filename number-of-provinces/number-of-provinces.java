class Solution {
    
    List<List<Integer>> provinces = new LinkedList();
    Set<Integer> ignore = new HashSet(); 
    Set<Integer> nodes = new HashSet(); 
    
    Map<Integer, Set<Integer>> graph = new HashMap(); 
    
    public int findCircleNum(int[][] isConnected) {
        
        
        
        createGraph(isConnected);
        System.out.println("GRAPH : "+graph); 
        for(int item : nodes)
        {
        findProvinces(item, graph);
        }
        
        System.out.println("PROVINCES : "+provinces); 
        
        return provinces.size();
    }
    
    public void findProvinces(int source, Map<Integer, Set<Integer>> graph)
    {
        //Province is number of nodes that belong to same neighborhood/network
        List<Integer> province = new LinkedList(); 
        Stack<Integer> system = new Stack(); 
        
        if(ignore.contains(source))
        {
            //Return, already computed
            return; 
        }
        
        system.add(source); 
        province.add(source); 
        ignore.add(source); 
        
        while(!system.isEmpty())
        {
            for(int item : graph.get(system.pop()) )
            {
                System.out.println("ITEM : "+item); 
                System.out.println("IGNORE : "+ignore); 
                if(ignore.contains(item))
                {
                    continue; 
                }
                
                province.add(item); 
                system.add(item); 
                ignore.add(item); 
            }
    
            
        }
        
        provinces.add(province); 
    
    }
    
    public void createGraph(int[][] matrix)
    {
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[0].length; j++)
            {
                if(matrix[i][j] == 1)
                {
                    int from = i+1; 
                    int to = j+1; //For presentation purposes
                    
                    Set<Integer> conn = 
                        graph.getOrDefault(from, new HashSet()); 
                    
                    conn.add(to); 
                    graph.put(from, conn); 
                    
                    conn = graph.getOrDefault(to, new HashSet()); 
                    
                    conn.add(from); 
                    graph.put(to, conn); 
                    
                    nodes.add(to); 
                    nodes.add(from); 
                }
            }
        }
    }
}