            int size = list.size(); 
            
            for(int k=0; k<size;k++)
            {
              int x=list.get(k).get(0); 
              int y = list.get(k).get(1); 
              
              ignore[x][y] = true; 
              
              explore(x, y, grid, list, ignore); 
              
              size = list.size(); 
            }
            count++; 
          }
          list.clear(); 
        }
      }
      
      return count; 
    }
  
  public void explore(int i, int j, char[][] grid, List<List<Integer>> list, boolean[][] ignore)
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
          list.add(tmp); 
          
          ignore[x][y] = true; 
          
        }
      }
    }
    
  }
}
