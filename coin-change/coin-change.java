class Solution {
    public int coinChange(int[] coins, int amount) {
       
        if(amount == 0)
        {
            return 0; 
        }
        
        Arrays.sort(coins); 
        
        int minimumCoins = -1; 
        TreeMap<Integer, Integer> map = new TreeMap(); 
        
        for(int coin : coins)
        {
            map.put(coin, coin);
        }
        
        //Repeatedly try to find the largest item less than amount
        int amountCopy = amount;
        int sum = 0;
        
        int[] arr = new int[amount+1];
        Arrays.fill(arr, amount+1);
        arr[0] = 0; 
        int count = 1; 
        while(count <= amount)
        {
            for(int j = 0; j < coins.length; j++){
            
            if(coins[j] <= count){
            arr[count] = Math.min(arr[count], arr[count-coins[j]]+1);
            }else
            {
                break;
            }
            }
            count++;
        } 
    
        
        if(arr[amount] > amount)
        {
            return -1;
        }
        
        return arr[arr.length-1]; 
    }
}
