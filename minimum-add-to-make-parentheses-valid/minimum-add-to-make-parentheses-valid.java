class Solution {
    public int minAddToMakeValid(String S) {
        Stack<Character> left = new Stack(); 
        
        int issues = 0; 
        
        for(int i = 0; i < S.length(); i++)
        {
            char item = S.charAt(i); 
            
            if(item == '(')
            {
                left.push(item);
            }else
            {
                if(!left.isEmpty())
                {
                    left.pop();
                }else
                {
                    issues++;
                }
            }
        }
        
        while(!left.isEmpty())
        {
            left.pop();
            issues++;
        }
        
        return issues; 
    }
}
