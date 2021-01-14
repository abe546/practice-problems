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
