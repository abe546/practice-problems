class Solution {

    Map<Integer, LinkedList<LinkedList<Integer>>> graph = new HashMap();

    public int networkDelayTime(int[][] times, int n, int k) {

        createGraph(times);
         
        Map<Integer, Integer> distance = new HashMap(); 
        //Should be size n by end of processes (verify all nodes can be reached)
              
        PriorityQueue<Integer[]> queue = new <Integer[]>PriorityQueue(
            (a,b) -> {
               //destination and weight (all source node is in relation to 2)
                Integer[] arr = (Integer[])a;
                Integer[] barr = (Integer[])b;
                
                return arr[1] - barr[1];
            });
        
        Integer[] root = {k, 0};
        
        queue.add(root);
        int max = -1;
        
        while(!queue.isEmpty())
        {
            Integer[] item = queue.poll(); 
            
            int source = item[0];
            int time = item[1];
            
            if(distance.get(source) == null){
            max = Math.max(max, time);
            }
            
            //key is node destination, and value is time to node
            //In context of root source (k)
            distance.put(source, time);
     
            if(graph.get(source) != null){
            for(List<Integer> items : graph.get(source))
            {
                if(distance.get(items.get(0)) != null)
                {
                    continue;
                }
                
             int dest = items.get(0); 
             int unit = items.get(1) + time;
                
             Integer[] tmpArr = {dest, unit};
                
            queue.add(tmpArr);
            }
            }
        }

        System.out.println("DISTANCE : "+distance); 
        
        if(distance.size() != n)
        {
            return -1;
        }
        
        return max; 
    }

    public void createGraph(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {

            int source = matrix[i][0];
            int dest = matrix[i][1];
            int weight = matrix[i][2];

            LinkedList<LinkedList<Integer>> info = 
                graph.getOrDefault(
                source, new LinkedList<LinkedList<Integer>>());

            LinkedList<Integer> tmp = new LinkedList(); 
            
            tmp.add(dest); 
            tmp.add(weight);

            info.add(tmp);
            
            graph.put(source, info);
        }
    }

}