            memory.clear(); //Release nodes we've seen
        }
        
        
        return true; 
    }
    
    public boolean findOrder(int source, Map<Integer, Set<Integer>> graph, Stack<Integer> order, Set<Integer> memory, Set<Integer> examined)
    {
        if(memory.contains(source))
        {
            System.out.println("MEMORY : "+memory); 
            System.out.println("SOURCE : "+source); 
            return false; 
        }
        
        //Keep track of items we've visited
        memory.add(source); 
        examined.add(source); 
        
        if(graph.get(source) == null || graph.get(source).isEmpty())
        {
            order.push(source);
            memory.remove(source); 
           
            return true;
        }
        
        for(int entry : graph.get(source))
        {
            //If at any point we encounter a parent as a dependent 
            //we know there is a deadlock
            if(findOrder(entry, graph, order, memory, examined) != true)
            {
                return false; 
            }else
            {
                //We visited
                memory.remove(entry); 
            }
        }
        
        return true; 
    }
    
    public void createGraph(Map<Integer, Set<Integer>> graph, int[][] prereqs)
    {
        for(int[] arr : prereqs)
