class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
       
        Map<String, Integer> memory = new HashMap();
        
         for(int i = 0; i < text1.length(); i++)
         {
             for(int j = 0; j < text2.length(); j++)
             {
                 if(text1.charAt(i) == text2.charAt(j))
                 {
                     memory.put(i+":"+j, memory.getOrDefault((i-1)+":"+(j-1), 0)+1);
                 }else
                 {
                     memory.put(i+":"+j, Math.max(
                     memory.getOrDefault(i-1+":"+j, 0), 
                     memory.getOrDefault(i+":"+(j-1), 0))
                     );
                 }
             }
             
      
         }
        
               return memory.get(text1.length()-1+":"+(text2.length()-1)); 
    }
}