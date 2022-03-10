class Solution {
    
    private int[][] movements = {
        {-1, 0}, //up
        {0,-1}, //left
        {1, 0}, //down
        {0, 1}, //right
        {1,1}, // down, right
        {-1, 1}, //up, right
        {-1, -1}, //up, left
        {1, -1},//down,left
    };
    
    private Map<String, Integer> cache = new HashMap(); 
    private boolean[][] tmpAvoid;
    private int min = Integer.MAX_VALUE;
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        int rowLength = grid.length-1;
        int colLength = grid[0].length-1;
        
        if(grid[0][0] != 0 || grid[rowLength][colLength] != 0)
        {
            return -1;
        }
        
        Queue<Cell> que = new LinkedList(); 
        
        que.add(new Cell(0,0,1));
        
        while(!que.isEmpty())
        {
            Cell current = que.poll(); 
            
           // System.out.println(current); 
            
            if(current.row == grid.length-1 && current.col == grid[0].length-1)
            {
                return current.steps;
            }
            
            //Get neighbors of current
            List<Cell> moves = traverse(current.row, current.col, grid, current.steps); 
            
            for(Cell item : moves)
            {
                que.add(item);
            }
        }
        
        return -1;
    }
    
    public List<Cell> traverse(int i, int j, int[][] grid, int steps)
    {        
        List<Cell> list = new ArrayList();
        
        for(int[] dir : movements)
        {
            int x = i + dir[0];
            int y = j + dir[1]; 
               
            if(x >= 0 && y >= 0 && x < grid.length && y < grid[0].length)
            {                
                if(grid[x][y] == 0 )
                {
                    //step into and explore
                    list.add(new Cell(x,y,steps+1));
                    grid[x][y] = 1; 
                    
                }else
                {
                    continue; 
                }
            }
        }
        
        return list; 
    }
    
    class Cell{
        int row;
        int col;
        int steps;
        
        public Cell(int row, int col, int steps)
        {
            this.row = row; 
            this.col = col; 
            this.steps = steps; 
        }
        
        public String toString()
        {
            return String.format("row: %s, col: %s, steps: %s", row, col, steps); 
        }
    }
    
    
}