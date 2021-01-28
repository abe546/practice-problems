class Solution {

    private TreeMap<Double, Integer> prefixSums = new TreeMap(); 
    private double totalSum = 0; 
    private int lastIndex = 0; 
    
    public Solution(int[] w) {
        
        int sum = 0; 
        
        for(int i = 0; i < w.length; i++)
        {
            sum+=w[i]; 
            
            prefixSums.put(sum*1.0, i); 
            lastIndex = i;
        }
        
        totalSum = sum;
    }
    
    public int pickIndex() {
        
        double target = totalSum * Math.random();
        
        Double key = prefixSums.ceilingKey(target); 
        
        if(key == null)
        {
            return lastIndex;
        }
        
        return prefixSums.getOrDefault(key, lastIndex);
        
        
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */