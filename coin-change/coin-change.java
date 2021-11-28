class Solution {
 
    
    public int coinChange(int[] coins, int amount) {
        
    int[] answer = new int[amount+1];
        
    Arrays.sort(coins);
  
    Arrays.fill(answer, amount+1); 
    answer[0] = 0; 
        
    for(int i = 1; i <= amount; i++)
    {
        for(int j = 0; j < coins.length; j++)
        {
            
            int coin = coins[j]; 
         
            if(coin > i)
            {
                break;
            }
            
           if(coin <= i)
           {
               answer[i] = Math.min(answer[i], answer[i-coin]+1);
           }
        }
    }
 
        if(answer[amount] > amount)
        {
            return -1; 
        }
        
        System.out.println("AMOUNT : "+amount); 
        System.out.println("ANSWER AMOUNT : "+answer[amount]); 
        
     return answer[amount];    
    }
}