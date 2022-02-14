class Trie {

    private Map<Character, Trie> map;
    private boolean endOfWord = false; 
    
    public Trie() {
 map = new HashMap(); 
        endOfWord = false; 
    }
    
    public void insert(String word) {
        Trie current = this; 
        for(int i = 0; i < word.length(); i++)
        {
            char item = word.charAt(i); 
 
            
        
            if(current.map.get(item) == null)
            {
                current.map.put(item, new Trie()); 
            }
            
            current = current.map.get(item); 
        }
        
        current.endOfWord = true; 
    }
    
    public boolean search(String word) {
        
        Trie current = this;
        
        for(char item : word.toCharArray())
        {
            if(current.map.get(item) == null)
            {
                return false; 
            }
            
            current = current.map.get(item);
        }
        
        return current.endOfWord;
    }
    
    public boolean startsWith(String prefix) {
        
        Trie current = this;
    
        for(char item : prefix.toCharArray())
        {
            if(current.map.get(item) == null)
            {
                return false; 
            }
            
            current = current.map.get(item);
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