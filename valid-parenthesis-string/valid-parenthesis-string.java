class Solution {
    public boolean checkValidString(String s) {
         
        return validString(s, 0, 0); 
    }
    
    public boolean validString(String input, int i , int open)
    {
        if(input.length()  == i)
        {
            return open == 0; 
        }
        
        if(open < 0)
        {
            return false;
        }
        
        char item = input.charAt(i);
        
        if(item == '(')
        {
            return validString(input, i+1, open+1);
        }
        
        if(item == ')')
        {
            return validString(input, i+1, open-1);
        }
        
        return validString(input, i+1, open+1) || validString(input, i+1, open-1) || validString(input, i+1, open);
    }
}
