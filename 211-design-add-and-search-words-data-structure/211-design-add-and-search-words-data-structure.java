class WordDictionary {
 
    private Map<Character, WordDictionary> dict = new HashMap();
    private boolean endOfWord = false; 
    private final static char WILD_CARD = '.';
    
    public void addWord(String word) {
 
        WordDictionary current = this; 
        char[] arr = word.toCharArray();
        
        for(char item : arr)
        {
            WordDictionary wordDict = current.dict.get(item);
            
            if(wordDict == null)
            {
                wordDict = new WordDictionary(); 
                current.dict.put(item, wordDict); 
            }
            
            current = current.dict.get(item); 
        }
        
        current.endOfWord = true; 
    }
    
    public boolean search(String word) {
 
        return search(word, this); 
    }
    
    private boolean search(String word, WordDictionary context)
    { 
        WordDictionary current = context; 
        char[] arr = word.toCharArray();
        
        for(int i = 0; i < arr.length; i++)
        {
            char item = arr[i];
          
            if(item == WILD_CARD)
            {
                for(char key : current.dict.keySet()){
                
                WordDictionary pointer = current.dict.get(key); 
                
                boolean result = search(word.substring(i+1, word.length()), pointer); 
                
                if(result)
                {
                    return result;
                }
                }
            }
            
            WordDictionary wordDir = current.dict.get(item);
            
            if(wordDir == null)
            {
                return false; 
            }
            
            current = current.dict.get(item);
        }
        
        return current.endOfWord;
    }
    
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */