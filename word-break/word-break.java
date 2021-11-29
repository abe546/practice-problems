class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
     
        String word = s; 
        Set<String> dict = new HashSet(); 
        
        for(String words : wordDict)
        {
            dict.add(words); 
        }
        
        boolean[] arr = new boolean[word.length()];
        arr[0] = true; 
        
        for(int i = 0; i < word.length(); i++)
        {
            for(int j = i; j < word.length()+1; j++)
            {
                String substring = word.substring(i, j); 
                
                if(dict.contains(substring) && arr[i])
                {
                    if(j == word.length())
                    {
                        return true; 
                    }
                    
                    arr[j] = true; 
                }
            }
        }
        
        return false; 
        
}
}
 