class Solution {
    public int climbStairs(int n) {
        
        if( n == 1)
        {
            return 1; 
        }
        
        if( n == 2)
        {
            return 2; 
        }
        
        //n == 1 - 1
       // n == 2 - 1, 1 - 2
      // n == 3 - 1, 1, 1 - 2, 1 - 1, 2
        
      //  n = 3 === count[n-1] + count[n-2]
        
     // n == 4 - 1, 1, 1, 1 - 2, 1, 1 - 1, 2, 1 - 1, 1, 2 - 2, 2
        // n = 4 === count[n-1] + count[n-2] 
        
    int[] count = new int[n+1];
        
    count[0] = 1;
    count[1] = 2;
        
    for(int i = 2; i < n; i++)
    {
        count[i] = count[i-1] + count[i-2];
    }

    return count[n-1];
    }
}