class Solution {
    public boolean isAnagram(String s, String t) {
        
        Map<Character, Integer> sMap = new HashMap(); 
        Map<Character, Integer> tMap = new HashMap(); 
        
        for(char entry : s.toCharArray())
        {
            sMap.put(entry, sMap.getOrDefault(entry, 0)+1); 
        }
        
        for(char entry : t.toCharArray())
        {
            tMap.put(entry, tMap.getOrDefault(entry, 0)+1); 
        }
        
        return sMap.equals(tMap); 
    }
}