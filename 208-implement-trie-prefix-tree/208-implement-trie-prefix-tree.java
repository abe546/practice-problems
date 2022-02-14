class Trie {
 
    private Map<Character, Trie> fieldMap;
    private boolean endOfWord; 
    
    public Trie() {
        fieldMap = new HashMap(); 
        endOfWord = false; 
    }
    
    public void insert(String word) {
        
        Trie current = this; 
        
        for(int i = 0; i < word.length(); i++)
        {
            char item = word.charAt(i); 
            
            Trie entry = current.fieldMap.getOrDefault(item, new Trie());
            current.fieldMap.put(item, entry);
            
            current = current.fieldMap.get(item); 
        }
        
        current.endOfWord = true; 
    }
    
    public boolean search(String word) {
        
        Trie current = this; 
        
        for(int i = 0; i < word.length(); i++)
        {
            
            char item = word.charAt(i); 
            if(current.fieldMap.get(item) == null)
            {
                return false; 
            }
            
            current = current.fieldMap.get(item); 
        }
        
        return current.endOfWord; 
    }
    
    public boolean startsWith(String prefix) { 

        Trie current = this; 
        
        for(int i = 0; i < prefix.length(); i++)
        {
            char item = prefix.charAt(i); 
            
            if(current.fieldMap.get(item) == null)
            {
                return false; 
            }
            
            current = current.fieldMap.get(item); 
        }
        
        return true; 
    }
        
 
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */