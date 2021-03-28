class Solution {
    
    
    Map<Integer, Integer> map = new HashMap();
    Set<List<Integer>> set = new HashSet(); 
    Set<Integer> ignoreDupe = new HashSet(); 
    public List<List<Integer>> threeSum(int[] nums) {
 
        
        for(int i =0; i < nums.length; i++)
        {
            map.put(nums[i], i);
        }
        
        
        for(int i = 0; i < nums.length; i++)
        {
            int item = nums[i];
            if(!ignoreDupe.contains(item)){
            getThreeSum(nums, -1 * item, i);
                ignoreDupe.add(item); 
            }
        }
        
        List<List<Integer>> answer = new LinkedList(); 
        
        for(List<Integer> item : set)
        {
            answer.add(item); 
        }
        
        return answer;
    }
    
    public void getThreeSum(int[] nums, int target, int index)
    {
        for(int i = 0; i < nums.length; i++)
        {
            if( i == index )
            {
                continue; 
            }
            
            if(ignoreDupe.contains(nums[i]))
            {
                continue; 
            }
            
            if(map.get(target - nums[i]) != null && map.get(target-nums[i]) != i && map.get(target-nums[i]) != index)
            { 
                
                List<Integer> list = new LinkedList();
                list.add(nums[index]);
                list.add(nums[i]);
                list.add(nums[map.get(target-nums[i])]);
                Collections.sort(list); 
                set.add(list); 
 
 
             
            }
        }
    }
}