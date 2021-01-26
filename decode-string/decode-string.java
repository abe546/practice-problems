class Solution {
    public String decodeString(String s) {
        
     return decodeTheString(s, 0);
    }
    
    public String decodeTheString(String input, int index)
    {  
        StringBuilder newString = new StringBuilder();
        
        while(index < input.length()){
         
        index = appendLetters(newString, index, input);
        
        index = appendNewString(newString, index, input); 
 
            
        }
        
        return newString.toString(); 
    }
    
    //Get the newString, which is the multiplication of the digit times the inner String
    public int appendNewString(StringBuilder component, int index, String input)
    {
        if(index >= input.length())
        {
            return index; 
        }
        
        StringBuilder numericItem = new StringBuilder();
        
         //At this point the char should be a number 
      //(either because we passed by letters, or because the first char is a number)
        index = appendDigits(numericItem, index, input); 
                       
        int newIndex=-1; 
        for(int i = 0; i < Integer.valueOf(numericItem.toString()); i++)
