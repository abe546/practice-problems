class Solution {
    public int search(int[] nums, int target) {
      
        int end = nums.length-1;
        int start = 0;
        int mid = (end - start)/2 + start;
        
        while(end >= start)
        {
            if(nums[mid] == target)
            {
                return mid;
            }else if(nums[mid] > target)
            {
                end = mid-1;
            }else if(nums[mid] < target)
            {
                start = mid+1;
            }
            
            mid = (end - start)/2 + start;
        }
        
        return -1;
    }
}