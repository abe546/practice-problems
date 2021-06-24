class Solution {
    public int search(int[] nums, int target) {
        //Sort the array
        Arrays.sort(nums);
        
        int start = 0; 
        int end = nums.length-1;
        
        while(start <= end)
        {
            int pivot = (end-start)/2 + start;
            
            if(nums[pivot] == target)
            {
                return pivot;
            }else if (nums[pivot] > target){
                end = pivot -1;
            }else if(nums[pivot] < target)
            {
            start = pivot +1; 
            }
            
                         
        }
        
        return -1; 
    }
}