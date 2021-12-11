class Solution {
 
    Map<String, String> map = new HashMap();
    Map<Integer, Integer> memo = new HashMap(); 
    public int numDecodings(String s) {
 
        String alphabet = "ABCDEFGHIJKLMNOPGRSTUVWXYZ";
        
        int count = 1;
        for(char item : alphabet.toCharArray())
        {
            map.put(String.valueOf(count++), ""+item);
        }
        
        return getDecodeCount(s, 0);
    }
    
    public int getDecodeCount(String input, int index)
    {     
        if(memo.get(index) != null)
        {
            return memo.get(index);
        }      
        String me = null; 
        
        if(index < input.length()){
        me = input.charAt(index)+"";
        
        if(map.get(me) == null)
        {
        
            return 0; 
        }
        }
         
        if(input == null || input.length() == 0 || index >= input.length() -1)
        {
            return 1; 
        } 
        
        
        
        int count = 0;
        count +=  getDecodeCount(input, index+1);
        
        if(input.length() >= index+1){
        me = me + input.charAt(index+1); 
         
        if(map.get(me) != null)
        {
            count += getDecodeCount(input, index+2);
        }
        }
        
        memo.put(index, count); 
        
        return count; 
    }   
}