class Solution {
    
    public List<List<Integer>> threeSum(int[] nums) {
          
        if(nums == null || nums.length == 0){
            return Collections.EMPTY_LIST;
        }
   
        List<List<Integer>> answer = new LinkedList(); 
        
        Arrays.sort(nums); 
        
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] > 0)
            {
                //Intention is to start off with 0 or a negative number
                continue;
            }
            
            if(i == 0 || nums[i-1] != nums[i])
            {
                find3Sum(i, nums, answer);
            }
        }
        
        
        return answer;
    }
    
    public void find3Sum(int i, int[] nums, List<List<Integer>> answer)
    {
        int j = i+1; 
        int k = nums.length-1;
        int sum = 0;
        
        while(j < nums.length && j < k)
        {
            sum = 0; 
            sum = nums[i] + nums[j] + nums[k]; 
            
            if(sum < 0)
            {
                j++;
            }else if(sum > 0)
            {
                k--;
            }else if(sum == 0)
            {
                List<Integer> tmp = new LinkedList(); 
                
                tmp.add(nums[i]); 
                tmp.add(nums[j]);
                tmp.add(nums[k]);
                
                answer.add(tmp); 
                j++;
                while(j < nums.length && nums[j] == nums[j-1]){
                j++;
                }
            }
        }
        
        
    }
    
   
 
}