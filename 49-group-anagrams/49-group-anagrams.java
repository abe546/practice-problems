class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Arrays.sort(strs, (a,b) ->
                    {
                       return a.length() - b.length(); 
                    });
        
        List<String> arr = new ArrayList(); 
 
        //For every String in array, sort based on chars
        for(String entry : strs)
        {
            char[] item = entry.toCharArray(); 
            Arrays.sort(item); 
            
            arr.add(new String(item)); 
        }
       
        List<List<String>> answer = new ArrayList(); 
        Set<Integer> avoid = new HashSet(); 
        for(int i = 0; i < arr.size(); i++)
        {
            if(avoid.contains(i))
            {
                continue; 
            }
            
            List<String> part = new ArrayList(); 
            String current = strs[i]; 
            
            part.add(current); 
            avoid.add(i); 
            
            for(int j = 0; j < arr.size(); j++)
            {
                if(j == i || avoid.contains(j))
                {
                    continue; 
                }
                
                if(arr.get(i).equals(arr.get(j)))
                {
                    part.add(strs[j]);
                    avoid.add(j); 
                }
            }
            
            answer.add(part); 
        }
        
       
        
        return answer; 
    }
}