class Solution {
    public boolean isPalindrome(String s) {
  
        String input = sanitizeString(s); 
        
        System.out.println("INPUT : "+input); 
        
        int i = 0; 
        int j = input.length()-1; 
        
        while( i < input.length() && i < j)
        {
            char first = input.charAt(i); 
            char second = input.charAt(j); 
            
            if(first != second)
            { 
                return false; 
            }
            
            i++; 
            j--; 
        }
        
        return true; 
    }
    
    public String sanitizeString(String input)
    {
        if(input == null)
        {
            return null; 
        }
        
        input = input.toLowerCase(); 
        
        StringBuilder stringBuilder = new StringBuilder(); 
        
        for(char item : input.toCharArray())
        {
            if(isNotAlphaNumeric(item))
            {
                continue; 
            }
            
            stringBuilder.append(item); 
        }
        
        return stringBuilder.toString(); 
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