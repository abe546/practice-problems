class Solution {
    public String reverseParentheses(String s) {
        
        StringBuilder reverseString = new StringBuilder();
        
        
        reverseStringBetweenParens(s, reverseString, 0);
        
     
        return reverseString.toString();
    }
    
    public int reverseStringBetweenParens(String input, StringBuilder reverseString, int index)
    {        
       for(int i = index; i < input.length(); i++)
       {
           char item = input.charAt(i); 
           System.out.println("ITEM : "+item); 
           if(Character.isLetter(item))
           {
               reverseString.append(item);
           }else if(item == '(')
           {
               StringBuilder tmp = new StringBuilder(); 
               
               i = reverseStringBetweenParens(input, tmp, i+1);
               reverseString.append(tmp); 
           }else if(item == ')')
           {
               reverseString = reverseString.reverse();
               return i; 
           }
       }
        
        return input.length(); 
    }
              
  
    
  
}
