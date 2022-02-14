class NumMatrix {

    private int[][] sumMatrix = null; 
    private int m = 0; 
    private int n = 0; 
    
    private Map<String, Integer> cache = new HashMap(); 
    
    public NumMatrix(int[][] matrix) {
        int sum = 0; 
        m = matrix.length;
        n = matrix[0].length; 
        
        sumMatrix = new int[m][n];
        
        for(int i = 0; i < m; i++)
        {
            sum = 0; 
            for(int j = 0; j < n; j++)
            {
                sum += matrix[i][j];
                
                sumMatrix[i][j] = sum;
            }
        }
       
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
     int sum = 0; 
 
        for(int i = row1; i <= row2; i++)
        {
            int currentRow = i; 
            int currentCol = col2;
            int diff = 0;
            
            if(col1 - 1 >= 0)
            {
                diff = sumMatrix[currentRow][col1-1];
            }
            //System.out.println("DIFF : "+diff); 
            sum += 
                sumMatrix[currentRow][currentCol]
                - 
                diff;
        }
        
   
        
        return sum; 
    }
        
 
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */