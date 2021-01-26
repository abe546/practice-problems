class Solution {
        List<List<String>> list = new LinkedList(); 
​
    public boolean validWordSquare(List<String> words) {
        //combinations(words, 0);
        
        for(int j = 0; j < words.size(); j++){
        for(int i = 0; i < words.get(j).length(); i++)
        {
            
            
            char item = words.get(j).charAt(i);
            
            if( i < words.size() && j < words.get(i).length() && item == words.get(i).charAt(j))
            {
                continue;
            }else
            {
                return false;
            }
        }
        }
        
       // System.out.println("LIST : "+list); 
        
        return true; 
    }
    
    public void combinations(List<String> words, int index)
    {
        for(int i = index; i < words.size(); i++)
        {
            String word1 = words.get(i); 
            words.set(i, words.get(index));
            words.set(index, word1);
            
            combinations(words, index+1);
            
            //Reset : 
            words.set(index, words.get(i));
            words.set(i, word1);
        }
        
        if(index == words.size() -1)
        {
             List<String> tmp = new LinkedList();
            for(int i =0; i < words.size(); i++)
            {
               tmp.add(words.get(i));
            }
            list.add(tmp); 
​
        }
    }
}
