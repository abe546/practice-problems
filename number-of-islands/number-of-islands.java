class Solution {
    //Array of coordinates
    //Where index 1 is row, index 2 is column
    int[][] boundary = {
        {0,1},
        {1,0},
        {0,-1},
        {-1,0}
    };
    
    //List<Integer> represents coordinates in a matrix
    //Where the first entry in the list is row, and second entry in the list is column
    // E.g. {1, 2} -> row 1 column 2
    Queue<List<Integer>> oneCoordinates = new ArrayDeque();
    Set<List<Integer>> explored = new HashSet();
    Set<List<Integer>> avoid = new HashSet(); 
    public int numIslands(char[][] grid) {
        
    for(int i = 0; i < grid.length; i++)
    {
        for(int j = 0; j < grid[0].length; j++)
        {
            if(grid[i][j] == '1')
            {
                List<Integer> tmp = new LinkedList(); 
                tmp.add(i); 
                tmp.add(j); 
                oneCoordinates.add(tmp);
            }  
        }
    }
        
    int islands = 0;     
    while(!oneCoordinates.isEmpty())
    {
        List<Integer> current = oneCoordinates.poll(); 
        avoid.clear(); 
        
        if(!explored.contains(current)){
        explore(grid, current, explored);
        islands++; 
        }
    }
        
        return islands;
    }
    
    public void explore(char[][] matrix, List<Integer> coordinate, Set<List<Integer>> explored)
    {
        int i = coordinate.get(0); 
        int j = coordinate.get(1); 
        
        if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length)
        {
            return;
        }
        
        if(matrix[i][j] == '0')
        {
            return; 
        }
        
        if(avoid.contains(coordinate))
        {
            return;
        }
        
        if(explored.contains(coordinate))
        {
            return;
        }
        
        avoid.add(coordinate);
        explored.add(coordinate); 
        
        for(int[] dir : boundary)
        {
            int x = i + dir[0]; 
            int y = j + dir[1];
            
            List<Integer> tmp = new LinkedList(); 
            
            tmp.add(x); 
            tmp.add(y); 
            
            explore(matrix, tmp, explored);
        }
        
    }
}