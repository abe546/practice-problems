class Solution {
    public int search(int[] nums, int target) {
        
        int index = -1;
        int start = 0; 
        int end = nums.length-1;
        int mid = 0; 
        while(start <= end){
        mid = start + (end-start)/2;
        
            
        if(target < nums[mid])
        {
            //look right of mid
            end = mid-1;
            
           
        }else if(target > nums[mid])
        {
            //look left of mid
           
            start = mid+1;
        }else if(target == nums[mid]){
            return mid; 
        }
        }
        
        return index; 
        
    }
}
