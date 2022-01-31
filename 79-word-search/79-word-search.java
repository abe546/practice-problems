class Solution {

    private int[][] boundary = {
        {0,1},
        {1,0},
        {-1,0},
        {0,-1}
    };
    private int[][] ignore = null; 
    public boolean exist(char[][] board, String word) {
 
        ignore = new int[board.length][board[0].length]; 
        
     for(int i = 0; i < board.length; i++)
     {
         for(int j = 0; j < board[0].length; j++)
         {
             ignore = new int[board.length][board[0].length]; 
             if(explore(i, j, board, word, 0))
             {
                 return true; 
             }
         }
     }
        
        return false;
    }
    
    public boolean explore(int i, int j, char[][] matrix, String word, int index)
    {
            
        if(ignore[i][j] == 1)
        {
            return false;
        }
        
        if(word.charAt(index) == matrix[i][j])
        {
            if(index+1 >= word.length())
            {
                return true; 
            }
            
            ignore[i][j] = 1;
            
            for(int[] dir : boundary)
            {
                int x = dir[0] + i;
                int y = dir[1] + j;
                
                if(x < matrix.length && y < matrix[0].length && x >= 0 && y >= 0 && ignore[x][y] != 1)
                {
                    if(explore(x, y, matrix, word, index+1))
                    {
                        return true; 
                    }
                }
            }
            
            ignore[i][j] = 0; 
        }
        
        return false; 
    }
     
}