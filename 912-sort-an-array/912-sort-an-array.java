class Solution {
    public int[] sortArray(int[] nums) {
        
        mergeSort(nums); 
        
        return nums; 
    }
    
    public void mergeSort(int[] nums)
    {
         if(nums.length == 1)
        {
            
            return;
        }
        
        int end = nums.length; 
        int start = 0;
        
        int mid = (end - start)/2; 
        
        int[] l = new int[mid];
        int[] r = new int[nums.length - mid];
        
        for(int i = 0; i < mid; i++)
        {
            l[i] = nums[i]; 
        }
        
        int j = 0; 
        
        for(int i = mid; i < nums.length; i++)
        {
            r[j++] = nums[i];
        }
        
        mergeSort(l);
        mergeSort(r); 
        
        sort(l, r, nums); 
    }
    
    public void sort(int[] l, int[] r, int[] nums)
    {
        int i = 0; 
        int j = 0; 
        int k = 0; 
        
        while(i < l.length && j < r.length && k < nums.length)
        {
            if(l[i] < r[j])
            {
                nums[k] = l[i];
                i++;
                k++;
            }else{
                nums[k] = r[j];
                j++;
                k++;
            }
        }
        
        while(i < l.length)
        {
            nums[k] = l[i];
            i++;
            k++;
        }
        
        while(j < r.length)
        {
            nums[k] = r[j]; 
            j++;
            k++; 
        }
    }
}