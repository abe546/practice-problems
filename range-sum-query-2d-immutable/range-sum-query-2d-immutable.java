class NumMatrix {
private Map<String, Integer> map;
private int[][] container = null; 
    
  public NumMatrix(int[][] matrix) {
    //214 ms using map
    if(matrix == null || matrix.length == 0)
    {
        return;
    }
      map = new HashMap(); 
      container = new int[matrix.length+1][matrix[0].length+1];
 
    for (int r = 0; r < matrix.length; r++) {
        for (int c = 0; c < matrix[0].length; c++) {
        
            int sum = matrix[r][c];
            
             container[r][c+1] = matrix[r][c] + container[r][c]; 
        }
    }
      
 
}

public int sumRegion(int row1, int col1, int row2, int col2) {
    int sum = 0;
    for (int row = row1; row <= row2; row++) {
  
            sum-=container[row][col1];
        
        
        sum += container[row][col2+1];
    }
    return sum;
}
    
public int sumRegionMap(int row1, int col1, int row2, int col2) {
    int sum = 0;
    for (int row = row1; row <= row2; row++) {
 
        if(map.get(row+":"+(col1-1)) != null)
        {
            sum-=map.get(row+":"+(col1-1));
        }
        
        sum += map.get(row+":"+col2);
    }
    return sum;
}
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */