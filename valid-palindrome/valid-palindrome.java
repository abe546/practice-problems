class Solution {
    public boolean isPalindrome(String s) {
 
        
        StringBuilder builder = new StringBuilder(); 
        
        for(char item : s.toLowerCase().toCharArray())
        {
            if(!Character.isLetter(item) && !Character.isDigit(item))
            {
                continue;
            }
         
            builder.append(item); 
      
        }     
        
        System.out.println("BUILDER : "+builder); 
 
     
       
       return builder.toString().equals(builder.reverse().toString()); 
    }
}