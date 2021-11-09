class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Set<List<Integer>> answerSet = new HashSet(); 
        List<List<Integer>> answer = new LinkedList(); 
        Set<Integer> avoidIndex = new HashSet(); 
        
        Map<Integer, Set<Integer>> map = new HashMap(); 
        
        for(int i = 0; i < nums.length; i++)
        {
            Set<Integer> tmp = map.getOrDefault(nums[i], new HashSet<Integer>()); 
            tmp.add(i); 
            map.put(nums[i], tmp); 
        }
        
      //  System.out.println("MAP : "+map); 
        
        for(int i = 0; i < nums.length; i++)
        {
            for(int j = 0; j < nums.length; j++)
            {
                if(  avoidIndex.contains(j))
                {
                    continue; 
                }
                
                if(i == j)
                {
                    continue; 
                }
                
                if(map.get(-1*(nums[i] + nums[j])) != null)
                {
                    int complement = -1*(nums[i] + nums[j]);
                    int size = map.get(-1*(nums[i] + nums[j])).size(); 
                    
                    if(nums[i] == complement && nums[j] == complement)
                    {
                        if(size < 3)
                        {
                            continue;
                        }
                    }else if(nums[i] == complement || nums[j] == complement)
                    {
                        if(size < 2)
                        {
                            continue;
                        }
                    }
                    
                    List<Integer> tmp = new LinkedList(); 
                    
                    tmp.add(nums[i]);
                    tmp.add(nums[j]);
                    tmp.add(complement);
                    
                    Collections.sort(tmp); 
                    
                    avoidIndex.add(i); 
            
                    
                    answerSet.add(tmp); 
                }
            }
        }
        
        
        for(List<Integer> list : answerSet)
        {
            answer.add(list); 
        }
        
        return answer; 
        
    }
}