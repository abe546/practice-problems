                sum+=item;
            }
            
            if(sum == target)
            presentAsList.add(entry);
        }
        
        return presentAsList; 
    }
    
    public void findNumbersThatSumToTarget( Map<Integer, Integer> numberMap, List<Integer> workUnit, Set<List<Integer>> answer, int target, int current, int[] candidates)
    {
        if(target < 0)
        {
            return; 
        }
       
   
        if(  target == 0)
        {  
            Collections.sort(workUnit); 
            List<Integer> copy = new LinkedList(); 
            copy.addAll(workUnit); 
         
            answer.add(copy);            
        }
         
        for(int i = 0; i < candidates.length; i++)
        {
            int curr = candidates[i]; 
         List<Integer> copy = new LinkedList(); 
            copy.addAll(workUnit); 
            copy.add(curr); 
         findNumbersThatSumToTarget(numberMap, copy, answer, target - curr, curr, candidates); 
         
       
        }
        
    }
}
