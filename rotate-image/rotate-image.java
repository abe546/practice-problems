class Solution {
    public void rotate(int[][] matrix) {
       
        //Get the column vectors of the matrix, and then 
        //we will replace the rows of the matrix with the bottom up order of columns
        
        List<Integer> columnVectors = new ArrayList(); 
        
        for(int i = 0; i < matrix[0].length; i++)
        {
            List<Integer> vector = new LinkedList(); 
            
            for(int j = 0; j < matrix.length; j++)
            {
                vector.add(0, matrix[j][i]);
            }
            
            columnVectors.addAll(vector);
        }
        
        int k = 0; 
        
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[0].length; j++)
            {
                matrix[i][j] = columnVectors.get(k++); 
            }
        }
        
        
        
    }
}
