class Solution {
    
    private int[][] fourDirections = 
    {
        {0,1},
        {0,-1},
        {-1,0},
        {1,0}
    };
    
    private boolean[][] seen = null; 
    
    public int maxAreaOfIsland(int[][] grid) {
      
        if(grid == null || grid.length == 0)
        {
            return 0;
        }
        
        seen = new boolean[grid.length][grid[0].length]; 
        int maxIslands = 0; 
        
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                if(grid[i][j] == 1 && seen[i][j] == false)
                {
                    List<List<Integer>> islands = new LinkedList(); 
                    
                    explore(grid, i, j, islands);
                    
                    maxIslands = Math.max(maxIslands, islands.size()); 
                }
            }
        }
        
        return maxIslands;    
    }
    
    public void explore(int[][] grid, int i, int j, List<List<Integer>> islands)
    {
        if(seen[i][j] == true)
