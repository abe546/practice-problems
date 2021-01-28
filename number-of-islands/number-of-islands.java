class Solution {
    private boolean[][] ignore;
   //Left, right, up, down 
   private int[][] dir = {
      {1,0},
      {-1,0},
      {0,1},
      {0,-1}
    };
    public int numIslands(char[][] grid) {
      boolean contains1 = false; 
      for(int i=0; i<grid.length; i++)
      {
        for(int j=0; j<grid[0].length; j++)
        {
          if(grid[i][j] == '1')
          {
            contains1 = true; 
            break; 
          }
        }
      }
      
      if(!contains1)
      {
        return 0; 
      }
      int count =0; 
      ignore = new boolean[grid.length][grid[0].length]; 
      
     
      
      for(int i=0; i<grid.length; i++)
      {
        for(int j=0; j<grid[0].length; j++)
        {
          if(grid[i][j] == '1' && ignore[i][j] == false)
          {
              Stack<List<Integer>> stack = new Stack();
             List<Integer> tmp = new ArrayList(); 
            tmp.add(i); tmp.add(j); 
            stack.push(tmp);
           
            
            while(!stack.isEmpty())
            {
                List<Integer> list = stack.pop();
                
              int x=list.get(0); 
              int y = list.get(1); 
              
              ignore[x][y] = true; 
              
              explore(x, y, grid, stack, ignore); 
           
            }
            count++; 
          }
        
        }
      }
      
      return count; 
    }
  
  public void explore(int i, int j, char[][] grid, Stack<List<Integer>> stack, boolean[][] ignore)
  {
    
    
    for(int[] move : dir)
    {
      int x = i + move[0]; 
      int y = j+ move[1]; 
      
      if(x>=0 && x<grid.length && y>=0 && y<grid[0].length && ignore[x][y] == false)
      {
        if(grid[x][y] == '1')
        {
          List<Integer> tmp = new ArrayList(); 
          tmp.add(x); tmp.add(y); 
          stack.push(tmp);
          
          ignore[x][y] = true; 
          
        }
      }
    }
    
  }
}