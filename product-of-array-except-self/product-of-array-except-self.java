class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int[] left = new int[nums.length]; 
        int[] right = new int[nums.length];
        left[0] = nums[0];
        right[nums.length-1] = nums[nums.length-1];
        
        for( int i = 1; i < nums.length; i++)
        {
            left[i] = nums[i] * left[i-1];
        }
        
        for(int i = nums.length-2; i > 0; i--)
        {
            right[i] = right[i+1]*nums[i]; 
        }
        
        int[] product = new int[nums.length];
        
        for(int i = 0; i < nums.length; i++)
        {
            int leftProduct = 1; 
            int rightProduct = 1; 
         
            if(i-1 >= 0)
            {
                leftProduct = left[i-1];
            }
            
            if(i + 1 < nums.length)
            {
                rightProduct = right[i+1]; 
            }
        
            System.out.println("LEFT : "+leftProduct);
            System.out.println("RIGHT : "+rightProduct); 
            
         product[i] = leftProduct * rightProduct; 
           
          
        }
        
        return product; 
    }
}