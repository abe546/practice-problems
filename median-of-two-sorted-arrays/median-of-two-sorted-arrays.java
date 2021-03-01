class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
     
        int[] arr = new int[nums1.length+nums2.length];
        
        int i = 0; 
        int j = 0; 
        int k = 0;
        
        while(i < nums1.length && j < nums2.length){
        
            if(nums1[i] < nums2[j])
            {
                arr[k] = nums1[i];
                i++;
                k++;
            }
            else
            {
                arr[k] = nums2[j];
                k++;
                j++;
            }
        }
        
        while(i < nums1.length)
        {
            arr[k] = nums1[i]; 
            k++;
            i++;
        }
        
        while(j < nums2.length)
        {
            arr[k] = nums2[j];
            j++;
            k++;
        }
        
        return findMedian(arr);
    }
    
    public double findMedian(int[] arr)
    {
        if(arr.length == 1)
        {
            return arr[0];
        }
        
        int mid = arr.length/2;
        double middle = arr[mid];
        if(arr.length % 2 == 0)
        {
            double middleMinus1 = arr[mid-1];
 
            double sum = middle+middleMinus1;
            return sum/2.0;
        } 
    
        return middle;
      
    }
}