class Solution {
    int[][] memory;
    public int minFallingPathSum(int[][] A) {
        
        int answer = Integer.MAX_VALUE;
        int[][] memory = new int[A.length][A[0].length];
        
        //Copy input array over
        for(int i = 0; i < A.length; i++)
        {
            for(int j = 0; j < A[0].length; j++)
            {
                memory[i][j] = A[i][j];
            }
        }
        
        for(int row = A.length-2; row >= 0; row--)
        {    
            for(int column = 0; column < A[0].length; column++)
            {
                //Check to see what is the minimum, eitther left, right middle
                int leftIndex = column - 1;
                int rightIndex = column + 1;
               
                int sum = memory[row+1][column];
                
                if(leftIndex >= 0)
                {
                    sum = Math.min(sum,  memory[row+1][leftIndex]);
                }
                
                if(rightIndex < A.length  )
                {
                    sum = Math.min(sum, memory[row+1][rightIndex]);
                }
                
                
                memory[row][column] += sum;
                        
        }
        }
        
