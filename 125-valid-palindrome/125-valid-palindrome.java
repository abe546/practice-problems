class Solution {
    public boolean isPalindrome(String s) {
        
        StringBuilder sb = new StringBuilder(); 
        
        
        for(char entry : s.toLowerCase().toCharArray())
        {
            if(Character.isLetter(entry) || Character.isDigit(entry))
            {
                sb.append(entry);
            }
        }
 
        
        for(int i = 0; i < sb.length(); i++)
        {
            char current = sb.charAt(i);
            char compare = sb.charAt(sb.length()-1-i);
            
            if(current != compare)
            {
                return false; 
            }
        }
       
        return true; 
    }
}