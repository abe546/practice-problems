class Solution {
    Map<String, String> map = new HashMap();
    Map<Integer, Integer> memo = new HashMap(); 
    public int numDecodings(String s) {
          String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        int count = 1; 
        for(char item : alphabet.toCharArray())
        {
            map.put(String.valueOf(count++), String.valueOf(item));
        }
        
        return decode(s, 0);
    }
    
    public int decode(String input, int index)
    {
        if(memo.get(index) != null)
        {
            return memo.get(index); 
        }
        
        String me = null; 
        
        if(index < input.length())
        {
            me = String.valueOf(input.charAt(index));
            
            if(map.get(me) == null)
            {
                return 0;
            }
        }else{
            return 1;
        }
        
        int count = 0; 
        
        count+= decode(input, index+1);
        
        if(index+1 <input.length())
        {
            me = me + input.charAt(index+1);
            
            if(map.get(me) != null)
            {
             count += decode(input, index+2); 
            }
        }
        
        memo.put(index, count); 
        
        return count; 
    }
}