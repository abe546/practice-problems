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
        
        return sb.toString().equals(sb.reverse().toString());         
    }
}