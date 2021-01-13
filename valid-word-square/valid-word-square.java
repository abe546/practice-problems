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
