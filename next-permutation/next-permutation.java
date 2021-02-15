class Solution {
    public void nextPermutation(int[] nums) {
     
        int indexEven =0; 
        
        if(nums == null || nums.length ==1 || nums.length == 0)
        {
            return; 
        }
        
        //Check if list is in ascending order
        boolean ascend = true; 
        boolean descend = true; 
        for(int i=0; i<nums.length-1; i++)
        {
 
            if(nums[i]>nums[i+1])
            {
                ascend = false; 
           
            }
            
             if(nums[i]<nums[i+1])
            {
                descend = false; 
    
            }
            
        }
        
        if(ascend)
        { 
            int temp = nums[nums.length-2]; 
            nums[nums.length-2] = nums[nums.length-1];
            nums[nums.length-1] = temp; 
            
            return;
        }
        
        if(descend)
        { 
            Arrays.sort(nums);
            return;
        }
    
        for(int i=nums.length-1; i>=0;i--)
        {
        
            if(i-1>=0 && nums[i-1]<nums[i])
            {
            indexEven = i; 
        
                i--;
             
                    //Find the smallest value larger than i
                        for(int j=nums.length-1; j>=indexEven; j--)
                        { 
                            if(nums[i]<nums[j])
                            {                                 
                                int temp = nums[i];
                                nums[i] = nums[j];
                                nums[j] = temp; 
                                break;
                            }else if(j == 0)
                            {
                              if(nums[i] == nums[j] && i ==0)
                                {
                                      int temp = nums[0];
                                nums[0] = nums[1];
                                nums[1] = temp; 
                                    break;
                                }
                                
                                int temp = nums[i];
                                nums[i] = nums[j];
                                nums[j] = temp; 
                                break;
                            }
                        }
   
                        //Reverse this sublist
                        int count =0; 
                        int start = indexEven;
                        int end = nums.length-1;
                        
                        while(start<end)
                        {
                            int temp = nums[start];
                            nums[start] =  nums[end];
                            nums[end] = temp;
                            start++;
                            end--;
                        }
                      
             
                        return; 
         
            } 

        
        }
     
    }
}