class Solution {
    public int maximumSum(int[] arr) {
   
        //The idea is similar to the product of array except self
        //We need to find the sum up to each index from left to right
        //Then we can ask ourselves if we look at the sum of 
        // left[0] + right[2] (missing 1) see which is the largest with the missing index. Or if its simply just the full array that's fine
        
        int currentSum = arr[0]; 
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];
        int finalSum = arr[0]; 
        left[0] = currentSum;
        for(int i = 1; i < arr.length; i++)
        {
            currentSum = Math.max(arr[i], currentSum+arr[i]); 
            
            left[i] = currentSum;
            
            finalSum = Math.max(currentSum, finalSum); 
        }
        
        finalSum = Math.max(currentSum, finalSum); 
        
        currentSum = arr[arr.length-1];
        right[arr.length-1] = currentSum; 
        
        for(int i = arr.length-2; i>=0; i--)
        {
            currentSum = Math.max(arr[i], currentSum+arr[i]); 
            right[i] = currentSum;
            
            finalSum = Math.max(currentSum, finalSum); 
        }
        
        for(int i = 1; i < arr.length-1; i++)
        {
            currentSum = left[i-1] + right[i+1];
            finalSum = Math.max(finalSum, currentSum); 
        }
                
        return finalSum; 
}
}
