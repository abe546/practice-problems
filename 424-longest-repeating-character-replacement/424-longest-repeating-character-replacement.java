class Solution {
 
    public int characterReplacement(String s, int k) {
 
        Map<Character, Integer> map = new HashMap(); 
        
        int left = 0; 
        int max = 0; 
        int result = 0; 
        for(int i = 0; i < s.length(); i++)
        {
            char rightItem = s.charAt(i); 
            char leftItem = s.charAt(left);
            
            map.put(rightItem, map.getOrDefault(rightItem, 0)+1);
            
            max = Math.max(map.get(rightItem), max); 
            
            int size = i - left;
            
            while( size - max >= k)
            {
                map.put(leftItem, map.get(leftItem)-1);
                
                left++;
                leftItem = s.charAt(left); 
                size = i - left;
            }
 
            
            result = Math.max(result, ++size); 
        }
        
        return result; 
    }
}
    
 