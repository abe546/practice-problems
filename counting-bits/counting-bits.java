class Solution {
    public int[] countBits(int n) {
       
        int size = n + 1; 
        int[] arr = new int[size];
        
        for (int i = 0; i < size; i++)
        {
          arr[i] = Integer.bitCount(i);
        }
        
        return arr; 
        
    }
     
}