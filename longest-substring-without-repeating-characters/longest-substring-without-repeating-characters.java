class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        Set<Character> record = new HashSet(); 
        
        int count =0; 
        int max = Integer.MIN_VALUE;
        
        Map<Character, Integer> lastIndex = new HashMap(); 
        
        for(int i=0; i<s.length(); i++)
        {
            char item = s.charAt(i); 
            
            if(!record.contains(item))
            {
                count++; 
                record.add(item);
                
                lastIndex.put(item, i); 
            }else
            {
                max = Math.max(max, count); 
                count =0; 
                record = new HashSet(); 
                i = lastIndex.get(item); //Reset i to see if the char can fit into a different set
              
            }
            
            
        }
        
        return Math.max(count, max); 
    }
}