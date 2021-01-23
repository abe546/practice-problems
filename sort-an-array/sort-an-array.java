        }
        
        int[] right = new int[nums.length-mid];
        
        for(int i = mid; i < nums.length; i++)
        {
             
            right[i - mid] = nums[i];
        }
        
        mergeSort(left);
        mergeSort(right);
        merge(left, right, nums);
    }
    
    public void merge(int[] left, int[] right, int[] nums)
    {
        int i = 0; 
        int j = 0;
        int k = 0; 
        
        while(i < left.length && j < right.length)
        {
            if(left[i] > right[j])
            {
                nums[k] = right[j];
                j++;
                k++;
            }else 
            {
                nums[k] = left[i];
                k++;
                i++;
            }
        }
        
        while(i < left.length)
        {
            nums[k] = left[i];
            k++;
            i++;
        }
        
        while(j < right.length)
        {
            nums[k] = right[j];
            k++;
            j++;
        }
    }
}
