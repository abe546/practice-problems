class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
 
        String[] sorted = new String[strs.length];
        
        for(int i = 0; i < strs.length; i++)
        {
            char[] arr =  strs[i].toCharArray();
            
            Arrays.sort(arr); 
            
            sorted[i] = new String(arr);
        }
        
        Map<String, List<String>> bank = new HashMap(); 
        
        for(int i = 0; i < strs.length; i++)
        {
            List<String> entries = bank.getOrDefault(
            sorted[i], new ArrayList<String>());
            
            entries.add(strs[i]);
            
            bank.put(sorted[i], entries); 
        }
        
        List<List<String>> answer = new ArrayList(); 
        
        for(String key : bank.keySet())
        {
            answer.add(bank.get(key));
        }
        
        return answer; 
        
    }
}