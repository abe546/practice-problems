        
        for(List<List<Integer>> islandItem : islands)
        {
            boolean surrounded = true;
            
            for(List<Integer> coordinates : islandItem)
            {
                int x = coordinates.get(0); 
                int y = coordinates.get(1); 
                
                if(!completelySurrounded(grid, x, y))
                {
                    surrounded = false; 
                    break;
                }
            }
            
            if(surrounded)
            {
                count++;
            }
        }
 
        
        return count;
    }
    
    public boolean completelySurrounded(int[][] grid, int i, int j)
    {
        int directionsAvailable = 0; 
        
        for(int[] dir : fourDirections)
        {
            int x = i+dir[0];
            int y = j+dir[1];
            
            if(x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && 
              (grid[x][y] == 1 || grid[x][y] == 0))
            {
                directionsAvailable++;
            }else
            {
                return false; 
            }
        }
        
        return true; 
    }
    
    public void createIslands(int[][] graph, List<List<Integer>> islands, int i, int j)
    {
        if(seen[i][j] == true)
        {
            return;
        }
        
        seen[i][j] = true; 
        List<Integer> tmp = new LinkedList(); 
