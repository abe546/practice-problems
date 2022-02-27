class Solution {
    public boolean isPalindrome(String s) {
        
        StringBuilder sb = new StringBuilder(); 
        
        for(char entry : s.toCharArray())
        {
            if(Character.isLetter(entry) || Character.isDigit(entry))
            {
                sb.append(entry);
            }
        }
        
        return sb.toString().toLowerCase().equals(sb.reverse().toString().toLowerCase());         
    }
}