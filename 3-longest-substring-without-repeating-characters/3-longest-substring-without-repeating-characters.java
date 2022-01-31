class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0; 
        Map<Character, Integer> map = new HashMap(); 
  
        int count = 0; 
        int index = 0; 
        while(index < s.length())
        {
            char item = s.charAt(index); 
            
            if(map.containsKey(item))
            {
                max = Math.max(max, count);
                count = 0; 
                index = map.get(item)+1; 
                item = s.charAt(index); 
                map = new HashMap(); 
            }

            count++;
            map.put(item, index);
            index++; 
            
              //   System.out.println("COUNT : "+count); 
            //System.out.println("ITEM : "+item); 
        }
 
        max = Math.max(max, count);
        
        return max;
    }
}