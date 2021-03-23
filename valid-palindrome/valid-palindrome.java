class Solution {
    public boolean isPalindrome(String s) {
  
        s = s.toLowerCase(); 
        
        int i = 0; 
        int j = s.length()-1; 
        
        while(i < j)
        {
           if(i < s.length() && isNotAlphaNumeric(s.charAt(i))){
           while(i < s.length() && isNotAlphaNumeric(s.charAt(i)))
           {
               i++;
           }
               
           continue; 
           }
            
           if(j > 0 && isNotAlphaNumeric(s.charAt(j))){
           while(j > 0 && isNotAlphaNumeric(s.charAt(j)))
           {
               j--;
           }
               
           continue; 
           }
            
            if(s.charAt(i) != s.charAt(j))
            {
                return false; 
            }
            
            i++; 
            j--; 
        }
        
        return true;
    }
    
    public boolean isNotAlphaNumeric(char character)
    {
        if(!Character.isDigit(character) && !Character.isLetter(character))
        {
            return true;
        }
        
        return false; 
    }
}