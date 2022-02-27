class Solution {
    
    private Map<Character, Character> relation = new HashMap(); 
    private Character[] left = {'(', '{', '['};
    private Character[] right = {')','}', ']'};
    private Set<Character> leftParens = new HashSet(); 
    private Set<Character> rightParens = new HashSet();
    private Stack<Character> stack = new Stack(); 
    private Map<Character, Character> keyMap = new HashMap(); 
    public boolean isValid(String s) {
 
        if(s == null && s.length() == 0)
        {
            return false;
        }
        
        leftParens.addAll(Arrays.asList(left));
        rightParens.addAll(Arrays.asList(right)); 
    
        for(int i = 0; i < left.length; i++)
        {
            keyMap.put(left[i], right[i]); 
        }
        
        for(char item : s.toCharArray())
        {
            if(leftParens.contains(item))
            {
                stack.add(item);
            }else if(rightParens.contains(item))
            {
                if(stack.isEmpty())
                {
                    return false; 
                }
                
                char current = stack.pop(); 
                
                if(!keyMap.get(current).equals(item))
                {
                    return false; 
                }
                
            }else
            {
                return false; 
            }
        }
        
        if(!stack.isEmpty())
        {
            return false; 
        }
        
    return true; 
    }
}