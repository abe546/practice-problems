        int i=0; 
    int j=0; 
    int k=0; 
    
    while(i<left.length && j<right.length)
    {
      if(left[i]>right[j])
      {
        nums[k] = right[j];
        j++;
        k++;
      }else
      {
        nums[k] = left[i];
        i++;
        k++;
      }
    }
    
    while(i<left.length)
    {
      nums[k] = left[i];
      i++; 
      k++;
    }
    
    while(j<right.length)
    {
      nums[k] = right[j];
      j++; 
      k++; 
    }
    }
}
