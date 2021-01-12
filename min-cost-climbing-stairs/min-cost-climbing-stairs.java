class Solution {
    int[] memory = null;
    public int minCostClimbingStairs(int[] cost) {
        
    memory = new int[cost.length];
    memory[memory.length-1] = cost[cost.length-1];
    memory[memory.length-2] = cost[cost.length-2];
 
        for(int i = cost.length-3; i >= 0; i--)
        {
            memory[i] += Math.min(cost[i]+memory[i+1], cost[i]+memory[i+2]);
        }
        
        return Math.min(memory[0], memory[1]); 
        
    }
    
    
}
