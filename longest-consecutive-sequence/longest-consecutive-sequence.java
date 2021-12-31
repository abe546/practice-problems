class Solution {
    private Map<Integer, Integer> map = new HashMap();
    private Set<Integer> ignore = new HashSet(); 
    public int longestConsecutive(int[] nums) {
        //TreeSet<Integer> set = new TreeSet(); 
        for(int num : nums)
        {
            map.put(num, num);
            //set.add(num); 
        }
        
        int count = 0;
        int max = 0; 
        for(int num : nums)
        {   count = 1;
            int current = num;
         
         if(ignore.contains(num))
         {
             continue;
         }
         current = num+1; 
            while(  map.get(current) != null)
            {
             
                count++;
                current++;
  
                ignore.add(current);
            }
         current = num-1; 
         while(  map.get(current) != null)
            {
                count++;
                current--;
         
                ignore.add(current);
            }
   
         max = Math.max(max, count); 
         ignore.add(num);
        }
        
       // System.out.println("TREE SET : "+set); 
        
        return max; 
    }
}