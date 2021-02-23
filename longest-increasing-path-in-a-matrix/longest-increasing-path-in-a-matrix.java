class Solution {
    
    private int longestPath = 0;
    private int[][] directions = 
    {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };
    
    private int[][] memoryPath;
    
    public int longestIncreasingPath(int[][] matrix) {
     
        memoryPath = new int[matrix.length][matrix[0].length];
    
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[0].length; j++)
            {
                longestPath = Math.max(longestPath, traverseMatrix(matrix, i, j, 0));
            }
        }
        
        return longestPath; 
    }
   
    public int traverseMatrix(int[][] matrix, int i, int j, int level)
    {
        if(memoryPath[i][j] != 0)
        {
            return memoryPath[i][j]; 
        }
        
        for(int[] dir : directions)
        {
            int x = i + dir[0]; 
            int y = j + dir[1];
            
            if(x >= 0 && x < matrix.length &&
               y >= 0 && y < matrix[0].length && 
               matrix[x][y] > matrix[i][j])
            {  
                memoryPath[i][j] = Math.
                    max(memoryPath[i][j], 
                        traverseMatrix(matrix, x, y, level+1)); 
            
            }
        }
        
        memoryPath[i][j] +=  1; 
        
        return memoryPath[i][j]; 
    }
    
}