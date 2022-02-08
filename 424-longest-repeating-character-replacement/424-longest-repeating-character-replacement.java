class Solution {
 
    public int characterReplacement(String s, int k) {
 
        Map<Character, Integer> map = new HashMap(); 
        
        int left = 0; 
        int max = 0; 
        int result = 0; 
        
        for(int i = 0; i < s.length(); i++)
        {
            char item = s.charAt(i);
            
            int count = map.getOrDefault(item,0)+1;
            map.put(item, count); 
            max = Math.max(max, count); 
            int size = (i - left + 1); 
            while( size - max > k)
            {
                map.put(s.charAt(left), map.get(s.charAt(left))-1);
                left++; 
                size = (i - left + 1);
            }
            
            //System.out.println("SIZE : "+size); 
            
            result = Math.max(result, size); 
        }
        
        //System.out.println("MAP : "+map); 
        
      return result;
    }
}
    
 