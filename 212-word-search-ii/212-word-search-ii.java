class Solution {
    
    private static final int[][] directions = 
    {
        {-1, 0},
        {1, 0}, 
        {0, 1},
        {0, -1}
    };
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> wordsThatExist = new LinkedList(); 
        
        
        for(String current : words)
        {
            //The idea is to traverse the matrix and see if the given word can
            //be formed with adjacent cells
            //IMPORTANT : As we do this, the matrix remains unchaged
            
            if(matrixContains(board, current))
            {
                wordsThatExist.add(current);
            }
        }
        
        return wordsThatExist; 
    }
    
    //Given some word, does the chars that make up the word exist in the board
    //In such a way that in order, from first char to last, it appears adjacent 
    //in the matrix
    public boolean matrixContains(char[][] board, String word)
    {
        //Iterate through matrix, when we find first char of word, start exploring
        
        boolean [][] ignore = new boolean[board.length][board[0].length];
        
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[0].length; j++)
            {
                if(board[i][j] == word.charAt(0))
                {
                    if(explore(board, i, j, ignore, word, 0))
                    {
                        return true;
                    }
                    
                    ignore = new boolean[board.length][board[0].length]; 
                }
            }
        }
        
        return false; 
    }
    
    public boolean explore(char[][] board, int i, int j, boolean[][] ignore, String word, int level)
    { 
       
        
        if(ignore[i][j] == true)
        {
            return false;
        }
        
        ignore[i][j] = true;
        
         if((level+1) == word.length())
        {
            return true;
            //At this point, we've explored all cels
            //and were able to get to all chars
        }
     
        
        for(int[] dir : directions)
        {
            int x = i+dir[0];
            int y = j+dir[1]; 
            
            if( x >= 0 && x < board.length &&
               y >= 0 && y < board[0].length &&  
               board[x][y] == word.charAt(level+1))
            {
                //Go explore for next char
                if(explore(board, x, y, ignore, word, level+1))
                {
                    return true; 
                }
            }
        }
        
        ignore[i][j] = false;
        
        return false; 
    }
    
    
}