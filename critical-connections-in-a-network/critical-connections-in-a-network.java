class Solution {
    private int count=-1; 
    private boolean[] visited; 
    private int[] low; 
    private int[] atTime; 
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
    
    Set<Integer>[] graph = new HashSet[n]; 
    low = new int[n]; 
    atTime = new int[n]; 
    visited = new boolean[n]; 
        
    for(int i=0; i< n; i++)
    {
        graph[i] = new HashSet(); 
     }    
        
        
    createGraph(connections, graph);
    List<List<Integer>> critical = new LinkedList();     
    dfs(0, -1, graph, critical); 
    //We also want to take into consideration: 
        //1. Nodes that have been visited already; will used boolean[] visited
        //2. Nodes low value, will use will use int[] low
        //3. ID designation, we will an integer iter : int count; 
        //4. At time of node exploration, value of low, e.g. capture low value before recursion,
        // will use int[] atTime
        
        return critical;
        
    }
    
    public void dfs(int currentNode, int parent, Set<Integer>[] graph, List<List<Integer>> critical)
    {
        visited[currentNode] = true; 
        count++; 
        low[currentNode] = count; 
        atTime[currentNode] = count; 
        
        for(int item : graph[currentNode])
        {
            if(parent == item)
            {
                continue; 
            }
            
            if(visited[item] != true)
            {
                dfs(item, currentNode, graph, critical);
            }
            
            if(atTime[currentNode] < low[item])
            {
                List<Integer> tmp = new LinkedList(); 
                tmp.add(currentNode); tmp.add(item); 
                
                critical.add(tmp); 
            }else{
            low[currentNode] = Math.min(low[currentNode], low[item]);    
            }
        }
        
    }
    
    
    public void createGraph(List<List<Integer>> connections, Set[] graph)
    {
        int to=0; 
        int from=0;
        
        for(List<Integer> item : connections)
        {
            to = item.get(1); 
            from = item.get(0);
            
            graph[from].add(to);
            graph[to].add(from); 
        }
    }
    
    
}
    
    