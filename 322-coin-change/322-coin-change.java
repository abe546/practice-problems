class Solution {
 
    public int coinChange(int[] coins, int amount) {
    
        int[] answer = new int[amount+1];
        
        Arrays.fill(answer, amount+1);
        Arrays.sort(coins);
        
        
        answer[0] = 0; 
        
        for( int i = 1; i <= amount; i++)
        {
            for(int j = 0; j < coins.length; j++)
            {
                int coinAmount = i;
                int smallerCoin = coins[j];
                
                if(smallerCoin > coinAmount)
                {
                    break; 
                }
                
                //coinAmount + smallerCoin = current Amount count
                //Similar to twoSum
                int index = coinAmount - smallerCoin;
                
                // We do answer[index]+1 because we get the value from before 
                // + 1 (the current coin) being used
                    answer[coinAmount] = 
                        Math.min(answer[coinAmount], answer[index]+1); 
   
            }
        }
        
        if(answer[amount] > amount)
        {
            return -1;
        }
        
        return answer[amount]; 
    }
}