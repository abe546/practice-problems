        {
            continue;
        }
 
        indexSet.add(i); 
    }
                
        int guess = 0; 
        while(!indexSet.isEmpty())
        {
            String examine = wordlist[indexSet.iterator().next()];
            int score = master.guess(examine);
 
            Set<Integer> tmp = new HashSet(); 
            for(int index : indexSet)
            {
                if(score == getScore(examine, wordlist[index]))
                {
                    tmp.add(index); 
                }
            }
            
            indexSet.clear();
            indexSet.addAll(tmp); 
            
            guess++;
            if(score == 6)
            {
                break; 
            }
        }
 
        
    }
    
    public int findMostDiverseWord(String[] wordlist)
    {
​
        Set<Character> charCount = new HashSet(); 
        int max = Integer.MIN_VALUE;
        int index = 0; 
        for(int j = 0; j < wordlist.length; j++)
        {
            String word = wordlist[j];
            
            charCount = new HashSet(); 
            for(int i = 0; i < word.length(); i++)
            {
                charCount.add(word.charAt(i));
            }
            
            if(max < charCount.size())
            {
                max = charCount.size();
                index = j;
            }
        }
        
        return index;
    }
    public int getScore(String word1, String word2)
    {
        int newScore = 0; 
        
      for(int i =0; i < word1.length(); i++)
      {
          if(word1.charAt(i) == word2.charAt(i))
          {
              newScore++;
          }
      }
