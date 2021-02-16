class Solution {
    public int longestConsecutive(int[] nums) {
     
      if(nums == null || nums.length ==0)
      {
        return 0; 
      }
            
      Arrays.sort(nums); 
      
      LinkedHashSet<Integer> set = new LinkedHashSet(); 
      
        ArrayList<Integer> list = new ArrayList(); 
        
      for(int item : nums)
      {
        list.add(item); 
      }
  
 
      
      int count =1; 
      int max = 0; 
      for(int i=0; i<list.size()-1;i++)
      {
        int item = list.get(i); 
        int item1 = list.get(i+1);
       
        if(item1 == (item+1))
        {
          count++; 
          max = Math.max(count, max); 
        }else if(item1 == (item))
        {
            continue;
        }else
        {
          count = 1;
          max = Math.max(count, max); 
        }
      }
      max = Math.max(count, max); 
      return max; 
    }
}