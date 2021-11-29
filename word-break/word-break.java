class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
     
        String word = s; 
        Set<String> dict = new HashSet(); 
        
        for(String item : wordDict)
        {
            dict.add(item);
        }
        
        boolean[] arr = new boolean[word.length()+1];
 
        arr[0] = true; 
 
        for(int i = 0; i < word.length()+1; i++)
        {
            for(int j = i; j <= word.length(); j++){
            String substring = word.substring(i, j);

           // System.out.println("SUBSTRING : "+substring);

                
                if(dict.contains(substring) && arr[i] )
            {
 
                arr[j] = true && arr[i];
                System.out.println("J : "+j); 
               System.out.println("I : "+i); 
                System.out.println("arr[j] : "+arr[j]); 
               System.out.println("ARR[j-i] : "+arr[i]); 
                
                if(i == 0)
                {
                    arr[i] = true; 
                }
            }
            }
            
            
            }
        
          return arr[arr.length - 1];    
         
        }
        }
 