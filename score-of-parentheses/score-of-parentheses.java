class Solution {
    public int scoreOfParentheses(String S) {
        int answer = 0; 
        
        char previous = '0';
        int in = 0; 
        for(char item : S.toCharArray())
        {
            if(item == '(')
            {
                in++;
            }else if(item == ')')
            {
                in--;
            }
            
            if(item == ')' && previous == '(')
            {
                answer+= Math.pow(2, in);
            }
            
            previous = item;
        }
        
        return answer;
    }
    
  
}
