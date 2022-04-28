class Trie {
 
    private boolean endOfWord;
    private Map<Character, Trie> mappings =  new HashMap<>();;
    
    public Trie()
    { 
    }
    
    public void insert(String word) {
        
        Trie current = this; 
        
        char[] arr = word.toCharArray(); 
        
        for(char item : arr)
        {            
            Trie entry = current.mappings.get(item);
            
            if(entry == null)
            {
                entry = new Trie(); 
                current.mappings.put(item, entry); 
            }
            
            current = entry; 
        }
        
        current.endOfWord = true; 
    }
    
    public boolean search(String word) {  
        
        Trie current = this; 
        
        char[] arr = word.toCharArray();
        
        for(char item : arr)
        {
            Trie entry = current.mappings.get(item);
            
            if(entry == null)
            {
                return false;
            }
            
            current = entry; 
        }
        
        return current.endOfWord;
    }
    
    public boolean startsWith(String prefix)
    {
        Trie current = this; 
        
        char[] arr = prefix.toCharArray();
        
        for(char item : arr)
        {
            Trie entry = current.mappings.get(item);
            
            if(entry == null)
            {
                return false;
            }
            
            current = entry; 
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