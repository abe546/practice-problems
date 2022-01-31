class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if(s == null || s.length() == 0)
        {
            return 0;
        }
        
        Map<Character, Integer> map = new HashMap(); 
        int count = 0; 
        int max = 0; 
        
        int index = 0; 
        
        while(index < s.length())
        {
            char item = s.charAt(index); 
            
            if(map.containsKey(item))
            {
                max = Math.max(count, max); 
                count = 0; 
                index = map.get(item)+1; 
                item = s.charAt(index); 
                map = new HashMap();
            }
            
            count++;
            map.put(item, index); 
            index++;
        }
        
        max = Math.max(max, count); 
        
        return max; 
        
    }
}