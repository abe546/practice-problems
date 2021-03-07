class Solution {
    
    Map<String, Integer> points = new HashMap();
    
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
    
        List<String> properWords = new LinkedList(); 
        
        Set<String> dict = new HashSet(); 
        
        sortByMinLength(words);
        
        for(String word : words)
        {
            if(word.length() > 0 && isMadeUpOfSmallerEntries(word, dict))
            {
                properWords.add(word);
            }
            
            dict.add(word); 
        }
        
        return properWords;
    }
    
    public boolean isMadeUpOfSmallerEntries(String word, Set<String> dict)
    {
 
        
        boolean[] memory = new boolean[word.length()+1]; 
        
        memory[0] = true; 
        
        for(int i = 1; i < memory.length; i++)
        {
            for(int j = 0; j < i; j++)
            {
                if(memory[j] == true && dict.contains(word.substring(j,i)))
                {
                    memory[i] = true; 
                    break; 
                }
            }
        }
        
        return memory[memory.length-1]; 
    }
    
    public void sortByMinLength(String[] words)
    {
        Arrays.sort(words, (a,b) ->
                    {
                        return a.length() - b.length();
                    });
    }
}