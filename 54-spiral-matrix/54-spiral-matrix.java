class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
         List<Integer> answer = new LinkedList();
        
        int left = 0; 
        int right = matrix[0].length-1;
        int up = 1;
        int down = matrix.length-1;
        
        int area = matrix.length * matrix[0].length;
        
        while(answer.size() < area)
        {
            for(int j = left; j <= right; j++)
            {
                if(answer.size() != area)
                answer.add(matrix[left][j]);
            }
            
            for(int i = up; i <= down; i++ )
            { if(answer.size() != area)
              answer.add(matrix[i][right]);  
            }
            
            for(int i = right-1; i >= left; i--)
            {   if(answer.size() != area)
                answer.add(matrix[down][i]);
            }
            
            for(int i = down -1; i >= up; i--)
            {   if(answer.size() != area)
                answer.add(matrix[i][left]);
            }
            
            left++;
            up++;
            down--;
            right--; 
 
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