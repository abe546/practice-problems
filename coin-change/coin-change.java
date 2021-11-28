class Solution {
 
    public int coinChange(int[] coins, int amount) {
    
        int[] answer = new int[amount+1];
        
        Arrays.fill(answer, Integer.MAX_VALUE-1);
        Arrays.sort(coins);
        
        
        answer[0] = 0; 
        
        for( int i = 1; i <= amount; i++)
        {
            for(int j = 0; j < coins.length; j++)
            {
                int coinAmount = i;
                int smallerCoin = coins[j];
                
                if(coins[j] > coinAmount)
                {
                    break; 
                }
                
                if(smallerCoin <= coinAmount)
                {
                    answer[coinAmount] = 
                        Math.min(answer[coinAmount], answer[coinAmount - smallerCoin]+1); 
                }
                
            }
        }
        
        if(answer[amount] > amount)
        {
            return -1;
        }
        
        return answer[amount]; 
    }
}