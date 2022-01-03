class Solution {
    
    private Map<Character, Set<Character>> graph = new HashMap();
    private Map<Character, Set<Character>> parent = new HashMap();
    
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
       
       
       buildRelations(words);
       
       if(isCycle())
       {
           return "";
       }
       
       while(allLetters.iterator().hasNext())
       {      
           //Find items who do not have a parent, return them
            findNoParents(allLetters, graph, parent, result);
           //Of the no parent items, remove from graph and remove from all letters
           for(Character item : result)
           {
               allLetters.remove(item);
               
               if(graph.get(item) != null){
               for(Character childNode : graph.get(item))
               { 
                       if(parent.get(childNode) != null && parent.get(childNode).contains(item))
                       {
                           parent.get(childNode).remove(item); 
                       }
              
               }
               
               graph.remove(item);
               }
           }
       }
       
       StringBuilder builder = new StringBuilder(); 
       
       for(Character item : result)
       {
           builder.append(item);
       }
      
    return builder.toString();
}
    
    public boolean isCycle()
    {
        for(Character item : parent.keySet())
        { 
            
            if(parent.get(item) != null )
            {
                for(Character parentItem :  parent.get(item))
                {
                    if(parent.get(parentItem) != null && parent.get(parentItem).contains(item))
                    {
                        return true; 
                    }
                }
            }
        }
        
        return false; 
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
    
    public void buildRelations(String[] words)
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
                    tmp = parent.getOrDefault(firstChar, new HashSet());
                    tmp.add(item); 
                    parent.put(firstChar, tmp); 
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
                    
                    tmp = parent.getOrDefault(word.charAt(i), new HashSet());
                    tmp.add(lastWord.charAt(i)); 
                    parent.put(word.charAt(i), tmp);  
                }
            }
            
            lastWord = word; 
        }
        
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
                  if(current.length() < prev.length() && prev.contains(current))
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