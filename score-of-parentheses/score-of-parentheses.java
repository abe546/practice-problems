class Solution {
    public int scoreOfParentheses(String S) {
        return validParens(S, 0, 0);
    }
    
    public int validParens(String input, int i, int depth)
    {   int answer = 0; 
        char prev = '0';
       for (char cur : input.toCharArray()) {
             
           if(cur == '(')
            {
                depth+=1;    
            }else if(cur == ')')
           {
               depth-=1;
           }
            if (prev == '(' && cur == ')')
                answer += Math.pow(2,depth);
            prev = cur;
        }
        return answer;
    }
}
