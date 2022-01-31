class Solution {
    public void rotate(int[][] matrix) {
      
        //Transpose matrix
        transpose(matrix);

        //Reflext matrix
        reflect(matrix); 
 
    }
    
    public void transpose(int[][] matrix)
    {
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = i + 1; j < matrix[0].length; j++)
            {
                int tmp = matrix[i][j]; 
                
                matrix[i][j] = matrix[j][i]; 
                matrix[j][i] = tmp; 
            }
        }
    }
    
    public void reflect(int[][] matrix)
    {
        for(int j = 0; j < matrix[0].length/2; j++)
        {
            for(int i = 0; i < matrix.length; i++)
            {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[0].length-1-j];
                matrix[i][matrix[0].length-1-j] = tmp; 
            }
        }
    }
    
    public void printArr(int[][] matrix)
    {
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[0].length; j++)
            {
                System.out.print(" "+matrix[i][j]+" ");
            }
             System.out.println();
        }
    }
}