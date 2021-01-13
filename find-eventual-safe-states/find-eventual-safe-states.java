class Solution {
    Set<Integer> safeNodes = new HashSet(); 
    Map<Integer, Integer> parentMap = new HashMap(); 
    Set<Integer> seen = new HashSet();
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        
        
        for(int i = 0; i < graph.length; i++)
        {
            if(graph[i].length == 0)
            {
                safeNodes.add(i); 
            }
        }
    
      
    
        for(int i = 0; i < graph.length; i++)
        {  
            if(safeNodes.contains(i))
            { 
                continue;
            }
            
            //If the only outgoing nodes are safe, then add to safe nodes
            for(int j = 0; j < graph[i].length; j++)
            {                
                int item = graph[i][j];
            
                if(!safeNodes.contains(item) )
                {
                    seen = new HashSet();
                    seen.add(i); 
                    if(isThisSafe(item, i, graph))
                    {
                        safeNodes.add(item); 
                        
                        if(j == graph[i].length -1)
                {
                    safeNodes.add(i); 
                }
                        
                        continue;
                    }
                    
                   
                    
                    break;
                }
           
                if(j == graph[i].length -1)
                {
                    safeNodes.add(i); 
                }
                
                
            }
           
