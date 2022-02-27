class Solution {
    public String longestPalindrome(String s) {
     
        if(s.length() < 2)
        {
            return s; 
        }
        
        String longest = ""+s.charAt(0);
  
        int start = 0; 
        int end = 0; 
        for(int i = 0; i < s.length(); i++)
        { 
   
                 int iter = i;
                int iterR = i;
                while(iter >= 0 && iterR < s.length() && s.charAt(iter) == s.charAt(iterR))
                { 
                    iter--;
                    iterR++;
   
                }
 
            if(end - start < iterR - iter - 1)
            {
                int len = iterR - iter - 1;
               start = i - (len - 1) / 2;
            end = i + len / 2;
            }
 
        }
 
                for(int i = 0; i < s.length(); i++)
        { 
                    
       
                int iter = i;
                int iterR = i+1;
 
 
                while(iter >= 0 && iterR < s.length() && s.charAt(iter) == s.charAt(iterR))
                {
             
                    iter--;
                    iterR++;
    
                }
 
     
                 if(end - start < iterR - iter - 1)
            {
                      int len = iterR - iter - 1;
                start = i - (len - 1) / 2;
            end = i + len / 2;
            }    
                    
        }
        
        

        return s.substring(start, end+1);
    }
}