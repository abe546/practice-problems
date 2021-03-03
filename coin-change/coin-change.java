class Solution {
    public int coinChange(int[] coins, int amount) {
       
        if(amount == 0)
        {
            return 0;
        }
        
        int[] combos = new int[amount+1]; 
        
        Arrays.fill(combos, amount+1); 
        Arrays.sort(coins); 
        combos[0] = 0; 
        
        
        for(int i = 1; i <= amount; i++)
        {
            int coin = i; 
            
            for(int j = 0; j < coins.length; j++)
            {
               if(coins[j] <= coin)
               {
                   combos[i] = Math.min(combos[i], combos[coin-coins[j]]+1);
               }else{
                   break; 
               }
            }
        }
        
        if(combos[amount] > amount)
        {
            return -1; 
        }
        
        return combos[amount]; 
    }
}