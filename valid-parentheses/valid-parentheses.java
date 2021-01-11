class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> left = new Stack(); 
        Stack<Character> right = new Stack(); 
        Map<Character, Character> parenMapping = new HashMap(); 
        parenMapping.put('(',')');
        parenMapping.put('{','}');   
        parenMapping.put('[',']');
​
        for(char item : s.toCharArray())
        {
            if(item == '(' || item == '[' || item == '{')
            {
                left.push(item);
            }else
            { 
                if(left.isEmpty())
                {
                    return false; 
                }
                
                if(parenMapping.get(left.pop()) != item)
                {
                    return false; 
                }
            }
        }
        
        if(!left.isEmpty())
        {
            return false; 
        }
        return true; 
        
    }
}
