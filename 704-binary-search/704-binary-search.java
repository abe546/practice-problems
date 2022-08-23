class Solution {
    public int search(int[] nums, int target) {
        
        int start = 0; 
        int end = nums.length -1;
        int mid = (end - start)/2;
        
        while(start <= end)
        {
            mid = ((end - start)/2)+start;
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
        }
        
        return -1;
    }
}