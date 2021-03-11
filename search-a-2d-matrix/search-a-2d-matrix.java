class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        //Find row where value may exist : 
        int[] arr = findRowWhereValueMayExist(matrix, target); 
        
        if(arr == null)
        {
            //No row had the target value or less in it
            return false; 
        }
        
        return findTargetValueInRow(arr[0], arr[1], matrix, target); 
    }
    
    public boolean findTargetValueInRow(int row, int columnLimit, int[][] matrix, int target)
    {
        for(int i = 0; i <= columnLimit; i++)
        {
            if(matrix[row][i] == target)
            {
                return true;
            }
        }
        
     return false; 
   
    }
    
    public int[] findRowWhereValueMayExist(int[][] matrix, int target)
    {
        for(int i = 0; i < matrix.length; i++)
        {
            if(target <= matrix[i][matrix[0].length-1])
            {
                int[] arr = {i, matrix[0].length-1};
                
                return arr;
            }
        }
        
        //Did not find a row this target seemingly could exist
        
        return null;
    }
}