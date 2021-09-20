class Solution {
    public int uniquePaths(int m, int n) {
        
        if(n == 0 || m == 0)
        {
            return 0;
        }
        
        int[][] arr = new int[m][n];
     
        for(int j = 0; j < n; j++)
            {
                arr[0][j] = 1;
            }    
       
       
        
        for(int i = 1; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                arr[i][j] += arr[i-1][j];
                
                if(j > 0){
                    arr[i][j] += arr[i][j-1];
                }
            }
        }
        
        return arr[m-1][n-1];
        
    }
}