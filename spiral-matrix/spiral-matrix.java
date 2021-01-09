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
