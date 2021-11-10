class Solution {
    public int maxArea(int[] height) {
               
        int max = -1; //Bound of problem, allows this as we should find numbers >= 0
        
        int i = 0;
        int j = height.length - 1; 
        
        while(i < j && i < height.length && j >= 0)
        {
            int multiply = j-i; 
            max = Math.max(max, Math.min(height[i], height[j])*multiply);
            
            if(height[i] > height[j])
            {
                j--;
            }else
            {
                i++;
            }
        }
        
        return max; 
        
    }
}