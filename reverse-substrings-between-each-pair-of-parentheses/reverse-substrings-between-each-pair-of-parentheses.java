class Solution {
    public String reverseParentheses(String s) {
        StringBuilder reverseString = new StringBuilder();
        
           int last = s.lastIndexOf(")");
        int first = s.indexOf("(");
        
        reverseStringBetweenParens(s, reverseString, 0, first, last);
        
     
        return reverseString.toString();
    }
    
    public int reverseStringBetweenParens(String input, StringBuilder reverseString, int index, int first, int last)
    {
        StringBuilder stringBuilder = new StringBuilder(); 
        
        for(int i = index; i < input.length(); i++)
        {
            char item = input.charAt(i);
            
            if(item == '(')
            {  
               i = reverseStringBetweenParens(input, stringBuilder, i+1, first, last);
            }else if(item != '(' && item != ')')
            {
                stringBuilder.append(item); 
            }else if(item == ')')
            {
                //break out of the loop
                //skipAhead
              
                    reverseString.append(stringBuilder.reverse().toString());
                return i;
            }
        }
        
        reverseString.append(stringBuilder.toString()); 
        
        return input.length(); 
    
    }
}
