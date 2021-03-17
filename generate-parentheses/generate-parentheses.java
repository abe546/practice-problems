class Solution {
    private List<String> present = new LinkedList();
    public List<String> generateParenthesis(int n) {
 
        
        createStrings("", 0, 0, n);
        
        return present; 
    }
    
    public void createStrings(String input, int left, int right, int limit)
    {
        if(input.length() == (2*limit))
        {
            present.add(input);
            return;
        }
        
        if(left < limit)
        {
            createStrings(input+"(", left+1, right, limit);
        }
        
        if(right < left)
        {
            createStrings(input+")", left, right+1, limit);
        }
    }
}