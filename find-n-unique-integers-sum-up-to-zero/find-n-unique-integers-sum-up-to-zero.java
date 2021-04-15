class Solution {
    public int[] sumZero(int n) {
        
        int[] arr = new int[n];
        int sum = 0;
        
        for(int i = 1; i < n; i++)
        {
            arr[i-1] = i;
            sum += i;
        }
        
        sum = sum * -1; 
        
        arr[arr.length-1] = sum;
        
        return arr;
    }
}