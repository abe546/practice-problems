class Solution {
    public int trap(int[] height) {
      
        //Intention is to find the min of right max or left max diff with current index
        //This will give us the height/difference of the current index/column vector
        //This is the diff for the singular column, not the entire area. Keep in mental model
        
        int leftMax = height[0];
        int[] rightMax = getRightMax(height);
        
        int amount = 0; 
        for(int i = 0; i < height.length; i++)
        {
            leftMax = Math.max(leftMax, height[i]);
            
            int diff = Math.min(leftMax - height[i], rightMax[i] - height[i]); 
            
            amount += diff; 
        }
        
        return amount; 
    }
    
    public int[] getRightMax(int[] arr)
    {
        int[] newArr = new int[arr.length];
        int max = arr[arr.length-1];
        
        newArr[arr.length-1] = max; 
        
        for(int i = 1; i < newArr.length; i++)
        {
            max = Math.max(arr[arr.length-i-1], max);
            
            newArr[arr.length-i-1] = max; 
        }
        
        return newArr; 
    }
    
    
}