class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        Map<Character, Integer> charToCount = new HashMap(); 
        Map<Character, Integer> charState = new HashMap(); 
        for(char entry : p.toCharArray())
        {
            //Keep count of occurrence of characters
            charToCount.put(entry, charToCount.getOrDefault(entry,0)+1); 
        }
 
        
        List<Integer> indexes = new LinkedList(); 
        
        int j = 0; 
        for(int i = 0; i < s.length(); i++)
        { 
            char current = s.charAt(i);
            
            if(i >= p.length())
            {
                char item = s.charAt(i-p.length());
                int count = charState.get(item);
                count--; 
                
                if(count == 0)
                {
                    charState.remove(item);
                }else
                {
                    charState.put(item, count);
                }
            }
            
            charState.put(current, charState.getOrDefault(current, 0)+1); 
            
            if(  charState.equals(charToCount))
            {
                indexes.add(i - p.length() +1); 
            }
            
        }
        
        return indexes; 
    }
}
