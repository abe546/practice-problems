class Solution {
​
    private TreeMap<Double, Integer> prefixSums = new TreeMap(); 
    private int[] copyArray = null; 
    private double totalSum = 0; 
    private int lastIndex = 0; 
    
    public Solution(int[] w) {
        
        int sum = 0; 
        copyArray = new int[w.length];
        for(int i = 0; i < w.length; i++)
        {
            sum+=w[i]; 
 
            copyArray[i] = sum; 
            lastIndex = i;
        }
        
        totalSum = sum;
    }
    
    public int pickIndex() {
        
        double target = totalSum * Math.random();
        
        int i = 0; 
        
        while( target >= copyArray[i])
        {
            i++;
        }
        
        if(i >= copyArray.length)
        {
            i = i -1; 
        }
        
        return i;
        
        
    }
}
​
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
