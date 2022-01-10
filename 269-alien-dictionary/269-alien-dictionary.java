class Solution {
    
    private Map<Character, Set<Character>> graph = new HashMap();
 
    private Set<Character> avoid = new HashSet(); 
    private Set<Character> ignore = new HashSet(); 
    private Set<Character> nodes = new HashSet(); 
   public String alienOrder(String[] words) {
    
       Set<Character> allLetters = new HashSet();
       List<Character> result = new LinkedList(); 
       
       if(!isValid(words))
       {
           return "";
       }
       
       for(String word : words)
       {
           getAllLetters(word, allLetters);
       }
       
       
       if(!buildRelations(words))
       {
           return "";
       }
     
 
      
       for(char item : graph.keySet()){
           avoid.clear();
       if(!topologicalSort(graph, result, item))
       {
           return "";
       }
       }
       
      for(char item : allLetters)
      {
          if(!nodes.contains(item)){
              result.add(0, item); 
          }
      }
        
       
       StringBuilder builder = new StringBuilder(); 
       
       for(Character item : result)
       {
       
           builder.append(item);
       }
       
 
      
    return builder.toString();
}
 
    public boolean topologicalSort(Map<Character, Set<Character>> graph, List<Character> list, Character item)
    {
        if(avoid.contains(item))
        { 
            return false;
        }
        
        if(ignore.contains(item))
        {
            return true;
        }
        
        nodes.add(item); 
        avoid.add(item); 
        
        boolean result = true; 
        
        if(graph.get(item) != null)
        for(char child : graph.get(item))
        {
            result = topologicalSort(graph, list, child) && result;
            
            if(result == false)
            {
                return false; 
            }
        }
        
        avoid.remove(item);
        ignore.add(item); 
        list.add(0, item); 
        
        return result;
    }
    
    public void findNoParents(Set<Character> allLetters, Map<Character, Set<Character>> graph, Map<Character, Set<Character>> parent, List<Character> result){
            
        for(Character item : allLetters)
        {
            if(parent.get(item) == null || parent.get(item).isEmpty())
            {
                result.add(item); 
            }
        }        
    }
    
    //Return false when detecting cycle
    public boolean buildRelations(String[] words)
    {
      
        Set<Character> soFar = new LinkedHashSet(); 
        String lastWord = null; 
        
        for(String word : words)
        {
            char firstChar = word.charAt(0); 
            
            if(!soFar.isEmpty() && !soFar.contains(firstChar))
            {
                for(Character item : soFar)
                {
                    Set<Character> tmp = graph.getOrDefault(item, new HashSet());
                    tmp.add(firstChar);
                    
                    graph.put(item, tmp); 
                    
                }
            }
            
            soFar.add(firstChar);
        }
        
        for(String word : words)
        {
            char firstChar = word.charAt(0); 
            
            if(lastWord == null)
            {
                lastWord = word;
                continue; 
            }
            
            if(firstChar != lastWord.charAt(0))
            {
                lastWord = word; 
                continue;
            }
                        
            int size =  Math.min(lastWord.length(), word.length());
            
            for(int i = 0; i < size; i++)
            {
                if(lastWord.charAt(i) != word.charAt(i))
                {
                    Set<Character> tmp = graph.getOrDefault(lastWord.charAt(i), new HashSet());
                    tmp.add(word.charAt(i));
                    
                    graph.put(lastWord.charAt(i), tmp);
                    
                     
                }
            }
            
            lastWord = word; 
        }
        
        return true; 
        
    }
    
    //Given words, check if valid sort order
    //Cannot have letters seperated, e.g. cannot have [a, b, a] makes sort ambiguous false
    //Cannot have smaller length prefix go after larger length prefix : [apple, app] false
    public boolean isValid(String[] words)
    {
        
        Set<Character> dupe = new HashSet(); 
        char lastChar = ' ';
        String lastString = "";
        Map<Character, List<String>> history = new HashMap(); 
        
        //O(n)
        for(String word : words)
        {
            if(word.length() < lastString.length() && isPrefix(lastString, word))
            {
                return false; 
            }
            
            if(dupe.contains(word.charAt(0)))
            {
                return false; 
            }
            
            if(lastChar != word.charAt(0))
            {
                dupe.add(lastChar);
            } 
            
            lastChar = word.charAt(0); 
            lastString = word; 
            
            List<String> tmp = history.getOrDefault(word.charAt(0), new ArrayList());
            tmp.add(word); 
            history.put(word.charAt(0), tmp); 
        }
        
        //O(n^2) 
        for(List<String> items : history.values())
        {
            for(int i = 0; i < items.size(); i++)
            {
                for(int j = i+1; j < items.size(); j++)
                {
                  String current = items.get(j); 
                  String prev = items.get(i); 
                  if(current.length() < prev.length() && isPrefix(prev, current))
                  {
                      return false; 
                  }
                    
                }
            }
        }
               

        return true; 
    }
    
    public boolean isPrefix(String word1, String word2)
    {
        int size = Math.min(word1.length(), word2.length());
        
        for(int i = 0; i < size; i++)
        {
            if(word1.charAt(i) != word2.charAt(i))
            {
                return false;
            }
        }
        
        return true;
    }
    
    public Set<Character> getAllLetters(String word, Set<Character> set)
    {
   
        for(char item : word.toCharArray())
        {
            set.add(item);
        }
        
        return set; 
    }
}