class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
  
    Set<String> dict = new HashSet(); 
        
    wordDict.stream().forEach(item -> dict.add(item)); 
        
    boolean[] memory = new boolean[s.length()+1];
    
    memory[0] = true;     
        
    for(int i = 1; i < memory.length; i++)
    {
        for(int j = 0; j < i; j++)
        {
            if(memory[j] == true && dict.contains(s.substring(j,i)))
            {
                memory[i] = true;
            }
        }
    }
        
    return memory[memory.length-1]; 
        
    }
}