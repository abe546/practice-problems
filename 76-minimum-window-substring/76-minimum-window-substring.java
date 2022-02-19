class Solution {
  public String minWindow(String s, String t) {
      Map<Character, Integer> charCount = new HashMap(); 
      Map<Character, Integer> compare = new HashMap(); 
      
      //Base case if S is less length than T return empty string
      if(s == null && t != null)
      {
          return "";
      }
      
      if(t != null && s.length() < t.length())
      {
          return "";
      }
      
      int uniqueChars = 0;
      
      for(int i = 0; i < t.length(); i++)
      {
          if(!compare.containsKey(t.charAt(i)))
          {
              uniqueChars++;
          }
          
          compare.put(t.charAt(i),
                     compare.getOrDefault(t.charAt(i),0)+1);
      }
      
      int leftP = 0;
      int min = -1;
      String subString = "";
      int requirement = 0; 
            
      for(int i = 0; i < s.length(); i++)
      {
          char current = s.charAt(i);
          
          int currCount = charCount.getOrDefault(current,0);
          currCount++;
          charCount.put(current, currCount);
          
          if(charCount.get(current).equals(compare.get(current)))
          {
              requirement++; 
          }
          
          if(requirement == uniqueChars)
          {   
              for(int j = leftP; j < s.length(); j++)
              {
                  int size = i - j + 1; 
                  
                  if(min == -1 || min > size)
                  {
                      min = size; 
                      subString = s.substring(j, i+1); 
                  }
                 
                  charCount.put(s.charAt(j), 
                           charCount.get(s.charAt(j))-1); 
 
                  //TODO MAKE A POINT ABOUT JAVA OBJECTS
                  if(charCount.get(s.charAt(j)).intValue() < compare.getOrDefault(s.charAt(j), 0).intValue()){
                      leftP = j+1;
                      requirement--;
                      break;
                  }
                  
                  leftP = j; 
              }
          }
      }
      
      return subString; 
  }
}