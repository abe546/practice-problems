class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        Map<Character, Integer> s1CharMap = new HashMap(); 
        Map<Character, Integer> s1CharMapOrigin = new HashMap(); 
        Set<Character> s1UniqueChars = new HashSet(); 
        for(char entry : s1.toCharArray())
        {
            s1CharMap.put(entry, s1CharMap.getOrDefault(entry,0)+1);
            s1UniqueChars.add(entry);
        }
        
        s1CharMapOrigin = new HashMap(s1CharMap); 
    
        for(int i = 0; i < s2.length(); i++)
        {
            char entry = s2.charAt(i); 
           
            
            for(int j = i; j < i+s1.length(); j++)
            {
                if(j >= s2.length())
                {
                    return false; 
                }
                entry = s2.charAt(j); 
            if(!s1CharMap.containsKey(entry))
            {
                //Start over : 
                s1CharMap = new HashMap(s1CharMapOrigin); 
                break; 
            }else
            {
                int value = s1CharMap.get(entry)-1;
                if(value > 0){
                s1CharMap.put(entry, value);
                }else
                {
                //If zero count, remove the key
                s1CharMap.remove(entry);
                }
          
            }
            
                if(s1CharMap.isEmpty())
                {
                    return true; 
                }
            }
            
        }
        
        System.out.println("MAP 2 : "+s1CharMapOrigin);
        
        return false;
    }
    
    
}
