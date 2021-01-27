        createGraph(graph, prerequisites);
​
        //Find topological sort of provided items : 
        for(int[] arr : prerequisites)
        {
            int source = arr[0]; 
            
            if(examined.contains(source))
            {
                continue; 
            }
            
            if(!findOrder(source, graph, memory, examined))
            {  
                int[] arr2 = new int[0]; 
                return arr2;
            }
            
           
            memory.clear(); //Release nodes we've seen
        }
 
        System.out.println("ORDER LIST : "+orderList); 
    
        int[] arr = new int[numCourses];
        
        int i = 0; 
        
        for(int item : orderList)
        {
            arr[i++] = item;
        }
        
        if(orderList.size() < numCourses)
        {
            for(int j = 0; j < numCourses; j++)
            {
                if(!nodes.contains(j))
                {
                    arr[i++] = j;
                }
            }
        }
  
        
        return arr; 
        
    }
    
    public boolean findOrder(int source, Map<Integer, Set<Integer>> graph, Set<Integer> memory, Set<Integer> examined)
    {
        if(memory.contains(source))
        { 
            return false; 
        }
        
        if(examined.contains(source))
