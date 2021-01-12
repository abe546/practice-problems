class Solution {
    public String minRemoveToMakeValid(String s) {
        
        Set<Integer> ignoreIndexes = new HashSet(); 
        //Will be a stack of indexes of '('
        //If there exists a vaid ')' will be popped, if not will be avoided
        Stack<Integer> left = new Stack(); 
        
        for(int i =0; i < s.length(); i++)
        {
            char item = s.charAt(i); 
            
            if(item == '(')
            {
                left.push(i);
            }else if(item != '(' && item != ')')
            {
                continue;
            }else if(item == ')')
            {
                if(left.isEmpty())
                {
                    ignoreIndexes.add(i);
                }else
                {
                    left.pop();
                }
            }
        }
