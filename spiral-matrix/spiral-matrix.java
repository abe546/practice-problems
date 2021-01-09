class Solution {
    private List<Integer> answer = new LinkedList(); 
    public List<Integer> spiralOrder(int[][] matrix) {
        
        int up = 0; 
        int down = matrix.length - 1;
        int right = matrix[0].length -1; 
        int left = 0;
        
        int entry = 1; 
        
        while(entry <= matrix[0].length * matrix.length)
        { 
            //GO RIGHT
            for(int i = up; i <= right; i++)
            {
                if(entry > matrix[0].length * matrix.length)
                {
                    break;
                }
           
                
                
                answer.add(matrix[up][i]); 
                entry++;
            }
 
            up++;
            //GO DOWN
            for(int i = up; i <= down; i++)
            {
                if(entry > matrix[0].length * matrix.length)
                {
                    break;
                }
                
                answer.add(matrix[i][right]); 
                entry++;
​
            }
       
            right--;
            
            //GO LEFT
            for(int i = right; i >= left; i--)
            {
                if(entry > matrix[0].length * matrix.length)
                {
                    break;
                }
                
                answer.add(matrix[down][i]);
                entry++;
​
            }
            down--;
            
            //Go UP
            for(int i = down; i >= up; i--)
            {
                if(entry > matrix[0].length * matrix.length)
                {
                    break;
                }
                
                answer.add(matrix[i][left]);
                entry++;
            }
            
            left++;
        }
  
        
        return answer; 
        
    }
    
    public int[][] rotateArray90DegreesToTheLeft(int[][] matrix) {
​
        int[][] tmpArray = new int[matrix[0].length][matrix.length-1];
​
        for(int j=matrix[0].length -1; j>=0; j--)
        {
            for(int i=1; i<matrix.length; i++)
            {
                tmpArray[ matrix[0].length - 1  - j][i-1] = matrix[i][j];
            }
        }
​
        return tmpArray;
    }
}
