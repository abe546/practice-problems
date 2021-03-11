class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
      
        if(matrix == null || matrix.length == 0)
        {
            return false; 
        }
        
        for(int i = 0; i < matrix.length; i++)
        {
            if(binarySearch(i, matrix, target))
            {
                return true;
            }
        }
        
        return false;
        
    }
    
    public boolean binarySearch(int row, int[][] matrix, int target)
    {
        int begin = 0; 
        int end = matrix[0].length -1; 
        
        while(begin <= end)
        {
            int pivot = (end - begin)/2 + begin; 
 
            if(matrix[row][pivot] < target)
            {
                begin = pivot + 1;
            }else if(matrix[row][pivot] > target)
            {
                end = pivot - 1;
            }else if(matrix[row][pivot] == target)
            {
                return true; 
            }
        }
        
        return false; 
    }
}