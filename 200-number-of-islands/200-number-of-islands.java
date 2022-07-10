class Solution {
 
    private int[][] directions = 
    {
        {0,1},
        {1,0},
        {-1,0},
        {0,-1}
    };
    
    private boolean[][] visited;
    private char ISLAND = '1';
    
    public int numIslands(char[][] grid) {
        int islands = 0; 
        
        // define visited array
        visited = new boolean[grid.length][grid[0].length];
        
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                if(visited[i][j] == false && grid[i][j] == ISLAND)
                {
                    explore(i, j, grid);
                    islands++;
                }
            }
        }
        
        return islands;
    }
    
     public void explore(int i, int j, char[][] grid)
     {
         if(visited[i][j] == true)
         {
             return;
         }
                  
         visited[i][j] = true;
         
         for(int[] dir : directions)
         {
             int x = dir[0] + i;
             int y = dir[1] + j;
             
             if(x < grid.length && x >= 0 && y < grid[0].length && y >= 0)
             {
                 if(grid[x][y] == ISLAND)
                 {
                     explore(x, y, grid);
                 }
             }
         }
     }
}