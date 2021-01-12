class Solution {
    public String removeOuterParentheses(String S) {
        //Iterate through the String, everytime we find () we concatanate it 
        //to String builder
        int depth = 0; 
        
        StringBuilder stringBuilder =new StringBuilder();
        char previous = '0'; 
        int leftCount = 0; 
        int rightCount = 0; 
        for(int i = 0; i < S.length() -1; i++)
        {
            char item = S.charAt(i);
       
            if(depth >= 1 && item == '(')
            {
                stringBuilder.append(item); 
                leftCount++;
            }else if(rightCount < leftCount && item == ')')
            {
                stringBuilder.append(item);
                rightCount++;
            }
            
            
            if(item == '(')
            {
                depth++;
            }else if(item == ')')
            {
                depth--;
            }
            
            
                
        }
        
        return stringBuilder.toString(); 
    }
}
