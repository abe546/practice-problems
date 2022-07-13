class Solution {
    public String longestCommonPrefix(String[] strs) {
        Map<String, Integer> prefixCount = new HashMap(); 
 
        for(int i = 0; i < strs.length; i++)
        {
            char[] arr = strs[i].toCharArray();
            String create = "";
            for(char item : arr)
            {
                create+=item;
                int count = prefixCount.getOrDefault(create, 0).intValue(); 
                count++;
                
                prefixCount.put(create, count);
            }
        }
        
        int max = 0; 
        String prefix = "";
        
        for(String item : prefixCount.keySet())
        {
            if(prefixCount.get(item) == strs.length)
            {
                if(max <= prefixCount.get(item))
                {
                    if(item.length() > prefix.length()){
                    
                    max = prefixCount.get(item); 
                    prefix = item;
                    }
                }
            }
        }
        
        return prefix; 
    }
}