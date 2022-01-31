class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
         List<Integer> answer = new LinkedList();
        
        if(matrix == null || matrix.length < 1)
        {
             return Collections.EMPTY_LIST;
        }
        
        getTopRow(matrix, answer);
        
        int[][] arr = rotateMatrixExceptTop(matrix);
       
        while(arr != null && arr.length >= 1)
        {
            getTopRow(arr, answer);
            
            arr = rotateMatrixExceptTop(arr);
        }
        
        return answer; 
        
    }
    
    public int[][] rotateMatrixExceptTop(int[][] matrix)
    {
        int[][] arr = new int[matrix[0].length][matrix.length-1];
        
        for(int j = 0; j < matrix[0].length; j++)
        {
            for(int i = 1; i < matrix.length; i++)
            {
                arr[j][i-1] = matrix[i][matrix[0].length-1-j];
            }
        }
        
        return arr;
    }
    
    public void getTopRow(int[][] matrix, List<Integer> list)
    {
        for(int i = 0; i < 1; i++)
        {
            for(int j = 0; j < matrix[0].length; j++)
            {
                list.add(matrix[i][j]); 
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