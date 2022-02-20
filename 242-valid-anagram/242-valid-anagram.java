class Solution {
    public boolean isAnagram(String s, String t) {
 
        if(s.length() != t.length())
        {
            return false; 
        }
        
        Map<Integer, Integer> map1 = new HashMap(); 
        Map<Integer, Integer> map2 = new HashMap(); 
        
        Set<Character> set = new HashSet(); 
        
        for(int i = 0; i < s.length(); i++)
        {
            map1.put(s.charAt(i)-'a', 
                    map1.getOrDefault(s.charAt(i)-'a', 0)+1); 
            
            map2.put(t.charAt(i)-'a', 
                    map2.getOrDefault(t.charAt(i)-'a', 0)+1); 
            
            set.add(s.charAt(i));
            set.add(t.charAt(i)); 
        }
       
  
        for(char entry : set)
        {
            if(map1.getOrDefault(entry-'a', 0).intValue() != map2.getOrDefault(entry-'a', 0).intValue())
            {
                return false; 
            }
        }
        
        return true;
    }
}