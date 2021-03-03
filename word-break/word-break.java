class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
 
     HashSet<String> set = new HashSet();
      
      set.addAll(wordDict); 
      
      boolean[] dp = new boolean[s.length()+1];
      
      dp[0] = true; 
 
      for(int i=1; i<=s.length(); i++)
      {
        for(int j=0; j<i; j++)
        {
          if(dp[j] && set.contains(s.substring(j,i)))
          {System.out.println("J : "+j); 
           System.out.println(" CHAR AT : "+s.charAt(j));
           System.out.println(" String : "+s.substring(j,i));
           //The way this loop is constructed is essentially to have the above i loop be 1 index based
           //For the reason that we are enlongating dp by s.length+1 but also to have our 
           //conditional check work
           //The idea is that we will say that if substring is in dictionary we will mark the dp[i] as true, this will 
          //then trigger that dp[j] (when it will be the last true i and there is a sub in the dictionary will ensure that
           //The new word is not only in the dictionary, but whatever came before it also was in the dictionary
           
           //USING BOOLEAN IS BETTER THAN TAKING FROM THE STRING AND CONTINUING AS ITS POSSIBLE ONE SUBSTRING IS A PART OF ANOTHER
           //SUBSTRING
            dp[i] = true; 
            break; 
          }
          
        }
        

      }
      
      
      return dp[s.length()]; 
    }
 
}