class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Arrays.sort(strs, (a,b) ->
                    {
                       return a.length() - b.length(); 
                    });
        
        String[] arr = new String[strs.length];
 
        //For every String in array, sort based on chars
        int k = 0; 
        for(String entry : strs)
        {
            char[] item = entry.toCharArray(); 
            Arrays.sort(item); 
            
            arr[k++] = new String(item); 
        }
       
        List<List<String>> answer = new ArrayList(); 
        Set<Integer> avoid = new HashSet(); 
        for(int i = 0; i < arr.length; i++)
        {
            if(avoid.contains(i))
            {
                continue; 
            }
            
            List<String> part = new ArrayList(); 
            String current = strs[i]; 
            
            part.add(current); 
            avoid.add(i); 
            
            for(int j = 0; j < arr.length; j++)
            {
                if(j == i || avoid.contains(j))
                {
                    continue; 
                }
                
                if(arr[i].equals(arr[j]))
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