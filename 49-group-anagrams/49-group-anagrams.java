class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> bank = new HashMap(); 
        List<List<String>> answer = new LinkedList(); 
        for(int i = 0; i < strs.length; i++)
        {
            char[] tmp = strs[i].toCharArray();
            Arrays.sort(tmp); 
            String current = new String(tmp);
            
            List<String> list = bank.getOrDefault(current, new ArrayList<String>());
            list.add(strs[i]);
            bank.put(current, list); 
        }
        
        for(String key : bank.keySet())
        {
            answer.add(bank.get(key));
        }
        
        return answer; 
    }
}