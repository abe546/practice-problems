class NumMatrix {
private Map<String, Integer> map;
private int[][] sumMatrix;
    
  public NumMatrix(int[][] matrix) {
    //214 ms using map
    if(matrix == null || matrix.length == 0)
    {
        return;
    }
 
      sumMatrix = new int[matrix.length][matrix[0].length];
      
      //Map will consist of sum of cells from left to right (columns)
      for(int i = 0; i < matrix.length; i++)
      {
          int sum = 0; 
          
          for(int j = 0; j < matrix[0].length; j++)
          {
              sum+=matrix[i][j];
              sumMatrix[i][j] = sum;
          }
      }
      
    }
      
 
 
public int sumRegion(int row1, int col1, int row2, int col2) {
    int sum = 0;
    
    for(int i = row1; i <= row2; i++)
    { 
            if(col1-1 < sumMatrix[0].length && col1-1 >= 0)
            {
                sum -= sumMatrix[i][col1-1];
            }
        
        sum+= sumMatrix[i][col2];
 
    }
    
    return sum;
}

public String getKey(int i, int j)
{
    return String.format("%s:%s",i,j);
}
}


/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */