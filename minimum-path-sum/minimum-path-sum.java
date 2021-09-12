class Solution {
    public int minPathSum(int[][] grid) {
        
        int[][] clone = new int[grid.length][grid[0].length];
        
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                if(i == 0 && j == 0)
                {
                    clone[i][j] = grid[i][j];
                }
                else{
                    if(i-1 >= 0 && j-1 >= 0)
                    {
                        clone[i][j] = Math.min(
                        clone[i-1][j] + grid[i][j],
                        clone[i][j-1] + grid[i][j]);
                        
                        //System.out.println("CLONE[i][j] : "+clone[i][j]); 
                    }
                    else if(i-1 >= 0)
                    {
                        clone[i][j] = clone[i-1][j] + grid[i][j];
                    }
                    else if(j-1 >= 0)
                    {
                        clone[i][j] = clone[i][j-1] + grid[i][j];
                    }
                    
                  
                }
                
                  System.out.println("CLONE[i][j] : "+clone[i][j]); 
            }
        }
        
        return clone[grid.length-1][grid[0].length-1];
        
    }
}