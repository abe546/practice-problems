
class Solution {
 
    Map<Integer, Set<DestinationTime>> sourceToDest = new HashMap(); 
    Map<Integer, Integer> minDistanceToK = new HashMap(); 
    public int networkDelayTime(int[][] times, int n, int k) {     
        
        createGraph(times);
        
        System.out.println(sourceToDest); 
        
        PriorityQueue<DestinationTime> que = 
            new PriorityQueue<>(
        (a,b)
        -> {
           return a.time - b.time; 
        });
        
        que.add(new DestinationTime(k, 0));
        
        int maxOfMins = -1;
        
        while(!que.isEmpty())
        {
            DestinationTime item = que.poll(); 
            
            if(minDistanceToK.get(item.destination) != null)
            {
                continue;
            }
            
            minDistanceToK.put(item.destination, item.time); 
            
            if(item.destination != k)
            {
                maxOfMins = Math.max(maxOfMins, item.time); 
            }
            
            if(sourceToDest.get(item.destination) != null)
            {
                for(DestinationTime entry : sourceToDest.get(item.destination))
                {
                    if(minDistanceToK.get(entry.destination) !=null)
                    {
                        continue;
                    }
                    
                    DestinationTime newItem = new DestinationTime(
                        entry.destination,
                        entry.time + item.time);
                    que.add(newItem); 
                }
            }
        }
        
        if(minDistanceToK.size() < n)
        {
            return -1; 
        }
        
        return maxOfMins; 
        
    } 
    
    // Create graph of source to dest + time.
    public void createGraph(int[][] times)
    {
        for(int i = 0; i < times.length; i++)
        {
            int source = times[i][0]; 
            int dest = times[i][1];
            int time = times[i][2];
            
            Set<DestinationTime> tmp = sourceToDest
                .getOrDefault(
                source,
                new HashSet<>());
            
            DestinationTime newItem = new DestinationTime(dest, time);
            
            tmp.add(newItem);
            
            sourceToDest.put(source, tmp); 

        }
    }
    
    class DestinationTime {
        int destination;
        int time;
        
        public DestinationTime(int destination, int time)
        {
            this.destination = destination;
            this.time = time;
        }
        
        public String toString()
        {
            return String.format("[%s, %s]", destination, time); 
        }
    }
   
   
}