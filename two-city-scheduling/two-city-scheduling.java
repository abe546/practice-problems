class Solution {
    public int twoCitySchedCost(int[][] costs) {
        
        Arrays.sort(costs, 
                    (a,b) ->
                    {
                        int[] aA = (int[])a;
                        int[] bB = (int[])b; 
                       return  aA[0] - aA[1] - (bB[0] - bB[1]);
                    });
        
        int total = 0;
    int n = costs.length / 2;
    // To optimize the company expenses,
    // send the first n persons to the city A
    // and the others to the city B
    for (int i = 0; i < n; ++i) total += costs[i][0] + costs[i + n][1];
    return total;
        
    }
}