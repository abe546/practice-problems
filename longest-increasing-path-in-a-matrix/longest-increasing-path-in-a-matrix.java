class Solution {
    public   int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
    public int longestIncreasingPath(int[][] matrix) {
         
        if(matrix == null || matrix.length == 0)
        {
            return 0; 
        }
 
        int[][] visited = new int[matrix.length][matrix[0].length];
    
        int answer = 0; 
        for(int i=0; i< matrix.length; i++)
        {
            for(int j=0; j< matrix[0].length; j++)
            { 
                answer = Math.max(answer, explore(matrix, i, j, visited, 1));
            
            }
        }
        
        return answer; 
        
    }
    
    public int explore(int[][] matrix, int i, int j, int[][] visited, int level)
    {
        if(visited[i][j] != 0)
        {
            return visited[i][j];
        }
        
         
         
        for(int[] ijIndex : directions)
        {
            int a = i+ijIndex[0]; 
            int b = j+ijIndex[1];
            if(a >=0 && a < matrix.length && b >=0 && b < matrix[0].length && matrix[a][b] > matrix[i][j]){
            visited[i][j] = Math.max(visited[i][j], explore(matrix, a, b, visited, level+1)); 
            }
        }
        
        return visited[i][j]+=1; 
        
    }
}
