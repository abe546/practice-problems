class Solution {
    public int trap(int[] height) {
       int answer = 0; 
      
      int[] left = new int[height.length]; 
      int[] right = new int[height.length]; 
      int max =0; 
      for(int i=0; i<height.length; i++)
      {
        max = Math.max(height[i], max); 
        left[i] = max; 
      }
      
      max =0; 
      for(int i=height.length-1; i>=0; i--)
      {
        max = Math.max(height[i], max); 
        right[i] = max; 
      }
      
      for(int i=0; i<height.length; i++)
      {
 
        answer += Math.min(left[i]-height[i], right[i]-height[i]); 
      }
      
      return answer; 
    }
}