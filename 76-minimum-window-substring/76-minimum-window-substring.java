class Solution {
  public String minWindow(String s, String t) {
 
      if (s.length() == 0 || t.length() == 0) {
          return "";
      }
      
      Map<Character, Integer> subMap = new HashMap(); 
      Map<Character, Integer> wordMap = new HashMap(); 
      
      for(char item : t.toCharArray())
      {
          subMap.put(item, 
                    subMap.getOrDefault(item, 0)+1);
      }
      
      int unique = subMap.size(); 
      int items = 0; 
      
      int left = 0; 
      int right = 0; 
      int bound = 0; 
      int begin = 0; 
      int end = 0; 
      
      while( right < s.length())
      {
          char current = s.charAt(right); 
          int count = wordMap.getOrDefault(current, 0); 
          count++; 
              wordMap.put(current, count);
 
          if(subMap.containsKey(current) && wordMap.get(current).intValue() == subMap.get(current).intValue())
          { 
              items++;
          }
 
          
          while( left <= right && items == unique)
          { 

              char leftChar = s.charAt(left); 
              
              if(bound == 0)
              {
                  bound = right - left + 1; 
                  begin = left; 
                  end = right+1;
              }else
              {

                if(bound > right - left + 1)
                {
                    bound = right - left + 1; 
                    begin = left;
                    end = right+1; 
                }
              }
     
     
                  wordMap.put(leftChar, 
                             wordMap.get(leftChar)-1);
                  
                   if(subMap.containsKey(leftChar) && wordMap.get(leftChar) < subMap.get(leftChar))
                  {
                       items--; 
        
                  }
           
              
               left++;
          }
          
          right++;
      }
      
      if(bound != 0)
      {
          return s.substring(begin, end);
      }
      
      return s.substring(begin, end); 
      
  }
}