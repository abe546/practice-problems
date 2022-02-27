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
        
        String newItem = sb.toString().toLowerCase();
        
        for(int i = 0; i < sb.length(); i++)
        {
            char current = newItem.charAt(i);
            char compare = newItem.charAt(sb.length()-1-i);
            
            if(current != compare)
            {
                return false; 
            }
        }
       
        return true; 
    }
}