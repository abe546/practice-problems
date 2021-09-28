class Solution {
    
    int[][] directions = 
    {
        {0,1},
        {1,0},
        {0, -1},
        {-1, 0}
    };
    
    Map<String, LinkedList<LinkedList<Container>>> graph = new HashMap(); 
    
    public int minimumEffortPath(int[][] heights) {
        
        createGraph(heights);
        //System.out.println("GRAPH : "+graph); 
        String root = getIdentifier(0,0); 
        int unit = 0; 
        
        Map<String, Integer> distance = new HashMap(); 
        
        PriorityQueue<Container> queue = new PriorityQueue();
        
        queue.add(new Container(root, unit));
        
        while(!queue.isEmpty())
        {
            Container entry = queue.poll(); 
            String source = entry.id;
            int amount = entry.unit;
            if(distance.get(source) == null){
            distance.put(source, amount);
                }
            
            distance.put(source, Math.min(distance.get(source), amount));
            
            if(graph.get(source) != null)
            {
                for(List<Container> pieces : graph.get(source))
                {
                    for(Container piece : pieces){
                    String newSource = piece.id;
                    int newAmount = Math.max(piece.unit, amount);
                    
                    if(distance.get(newSource) != null)
                    {
                        continue; 
                    }
                    
                    queue.add(new Container(newSource, newAmount));
                    }
                }
            }
            
        }
        
        return distance.get(getIdentifier(heights.length-1, heights[0].length-1)); 
        
    }
    
    public void createGraph(int[][] heights)
    {
        for(int i = 0; i < heights.length; i++)
        {
            for(int j = 0; j < heights[0].length; j++)
            {
                String source = getIdentifier(i, j); 
                
                for(int[] dir : directions)
                {
                    int x = dir[0]; 
                    int y = dir[1]; 
                                        
                    if(i+x >= 0 && i+x < heights.length && j+y >= 0 && j+y < heights[0].length){
                        LinkedList<LinkedList<Container>> tmp = 
                            graph.getOrDefault(source, 
                                               new LinkedList<LinkedList<Container>>());
                        
                        LinkedList<Container> item = new LinkedList(); 
                        
                        item.add(new Container(
                            getIdentifier(x+i, y+j),
                            Math.abs(heights[i][j] - heights[x+i][y+j])));
                        
                        tmp.add(item);
                        
                        graph.put(source, tmp); 
                    }
                }
            }
        }
    }
    
    public String getIdentifier(int i, int j)
    {
        return String.format("%s:%s", i, j); 
    }
    
    
}

class Container implements Comparable{
        String id = null; 
        int unit = Integer.MAX_VALUE;
        
        public Container(String id, int unit)
        {
            this.id = id;
            this.unit = unit;
        }
        
        public String toString()
        {
            return String.format("%s,%s", id, unit);
        }
        
        public int compareTo(Object item)
        {
            Container input = (Container)item;
            
            return this.unit - input.unit;
        }
            
    }