class Solution {
    public int maxProfit(int[] prices) {
 
 
        int answer = 0; 
        int[] minArr = new int[prices.length];
 
        int minSoFar = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++)
        {
            minSoFar = Math.min(minSoFar, prices[i]);
            
            minArr[i] = minSoFar;
        }
        
        for(int i = prices.length-1; i >=0; i--)
        {
          answer = Math.max(answer, prices[i] - minArr[i]);   
        }
        
        return answer; 
    }
}
