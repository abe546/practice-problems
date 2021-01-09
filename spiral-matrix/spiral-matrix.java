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
