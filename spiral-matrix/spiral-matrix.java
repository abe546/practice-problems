class Solution {
    private List<Integer> answer = new LinkedList(); 
    public List<Integer> spiralOrder(int[][] matrix) {
  
        int[][] clone = new int[matrix.length][matrix[0].length];
        
        cloneMatrix(clone, matrix); 
        
        while(clone.length > 0)
        {
            for(int i = 0; i < 1; i++)
            {
                for(int j = 0; j < clone[0].length; j++)
                {
                    answer.add(clone[i][j]); 
                }
            }
            
            clone = rotateMatrixMinus1(clone); 
        }
        
        
                
        return answer; 
    }
    
    public int[][] rotateMatrixMinus1(int[][] matrix)
    {
        int[][] rotate = new int[matrix[0].length][matrix.length-1];
        
        for(int col = 0; col < matrix[0].length; col++)
        {
            for(int row = 1; row < matrix.length; row++)
            {
                rotate[col][row-1] = matrix[row][matrix[0].length-1-col];
            }
        }
        
        return rotate; 
    }
    
    public void cloneMatrix(int[][] clone, int[][] matrix)
    {
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[0].length; j++)
            {
                clone[i][j] = matrix[i][j]; 
            }
        }
    }
    
    public void printMatrix(int[][] matrix2)
    {
        for(int i = 0; i < matrix2.length; i++)
        {
            for(int j = 0; j < matrix2[0].length; j++)
            {
                System.out.print(" "+matrix2[i][j]); 
            }
            
            System.out.println(""); 
        }
    }
 
 
}