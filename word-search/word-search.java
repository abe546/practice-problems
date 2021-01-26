            
                if(explore(i, j, board, 0+1, word))
                {
                    return true; 
                }
           
              
        }
         
        
        
        return false; 
    }
    
    public boolean explore(int i, int j, char[][] board, int charIndex, String word)
    {  
        
        if(charIndex >= word.length())
        { 
            return true; 
        }
        
        if(ignore[i][j] == true)
        {
            return false; 
        }
        ignore[i][j] = true; 
      
        boolean statement = false; 
        for(int[] dir : directions)
        {
