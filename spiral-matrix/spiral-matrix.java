class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        LinkedList<Integer> list = new LinkedList();
​
        if(matrix.length == 2 && matrix[0].length ==1)
        {
            list.add(matrix[0][0]);
            list.add(matrix[1][0]);
            return list;
        }
        
        if(matrix.length == 0)
        {
            return Collections.EMPTY_LIST;
        }
​
       
​
            for (int i = 0; i < 1; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    list.add(matrix[i][j]);
                }
      
​
            //Rotate the entire matrix system 90 degrees to the left
​
            int[][] tmpArray = rotateArray90DegreesToTheLeft(matrix);
​
            list.addAll(spiralOrder(tmpArray));
        }
​
         return list;
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
           
