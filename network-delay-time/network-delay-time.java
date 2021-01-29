class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        
        Map<Integer, List<List<Integer>>> graph = new HashMap();
        Map<Integer, Integer> distance = new HashMap();
        
        for(int[] info : times)
        {
            int sourceNode = info[0];
            int target = info[1];
            int dist = info[2];
            
            List<Integer> tmp = new LinkedList();
            tmp.add(target); 
            tmp.add(dist);
            
            List<List<Integer>> tmpList = graph.getOrDefault(sourceNode, new LinkedList<List<Integer>>());
            
            tmpList.add(tmp); 
            
            graph.put(sourceNode, tmpList); 
        }
        
        //Source node is K
        List<Integer> origin = new LinkedList(); 
        origin.add(K); 
        origin.add(0); 
        
        PriorityQueue<List<Integer>> queue = new PriorityQueue<List<Integer>>(
        (a,b) ->
            {
               int aDist = a.get(1); 
               int bDist = b.get(1);  
                
               return aDist - bDist; 
            });
        
        queue.add(origin); 
        int answer = 0; 
        while(!queue.isEmpty())
        {
            List<Integer> targetAndDistance = queue.poll(); 
            
            int target = targetAndDistance.get(0); 
            int dist = targetAndDistance.get(1);
            
            if(distance.get(target) != null)
            {
                continue; 
            }
            answer = Math.max(answer, dist); 
            distance.put(target, dist); 
            
            if(graph.containsKey(target))
            {
                for(List<Integer> info : graph.get(target))
                {
                    int targetInfo = info.get(0); 
                    int distInfo = info.get(1); 
                    
                    if(distance.get(targetInfo) == null){
                        List<Integer> tmp = new LinkedList(); 
                        
                        tmp.add(targetInfo); 
                        //Add the distance of the original target
                        tmp.add(distInfo+dist); 
                        
                        queue.add(tmp); 
                    }
                }
            }
        }
  
        
        if(distance.size() != N)
        {
            return -1; 
        }
        
        return answer; 
    }
}