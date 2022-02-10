class Solution {
    
    private int[][] boundary = {
        {0,1},
        {1,0},
        {0,-1},
        {-1,0}
    };
    
    /*
    * Each set, PAC set and ATL set, are a set of coordinates on the matrix. Where the inner list is of
    size 2, first entry being the row number of the index in the matrix and the second list entry being
    the column number of the index in the matrix. E.g. {1,2} -> Row 1 Column 2
    */
    private Set<List<Integer>> pacSet = new HashSet(); 
    private Set<List<Integer>> atlSet = new HashSet(); 
    
    private Queue<List<Integer>> atlQue = new ArrayDeque(); 
    private Queue<List<Integer>> pacQue = new ArrayDeque(); 
    
    private Set<List<Integer>> avoid = new HashSet(); 
    private Set<List<Integer>> cache = new HashSet(); 
     
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
    
        List<List<Integer>> answer = new LinkedList(); 
        
        getColumns(heights, pacSet, atlSet, pacQue, atlQue);
        getRows(heights, pacSet, atlSet, pacQue, atlQue);
        
        while(!pacQue.isEmpty())
        {
            List<Integer> current = pacQue.poll(); 
            avoid.clear();     
            //Find related nodes to pacQue items, add to pacSet (not queue, not needed)
            findRelatedNodes(heights, current, pacSet, cache);
        }
        
        cache.clear(); 
        
        while(!atlQue.isEmpty())
        {
            List<Integer> current = atlQue.poll(); 
            avoid.clear();     
            //Find related nodes to pacQue items, add to pacSet (not queue, not needed)
            findRelatedNodes(heights, current, atlSet, cache);
        }
        

        
        for(List<Integer> coordinate : atlSet)
        {
            if(pacSet.contains(coordinate))
            {
                answer.add(coordinate); 
            }
        }
        
        return answer;   
    }
    
    /*
    * Given matrix, coordinate, set of coordinates and cache of explored coordinates of ocean (Pacific or Atlantic)
    Where coordinate is a integer list, where entry 0 is row and entry 1 is column
    */
    public void findRelatedNodes(int[][] matrix, List<Integer> coordinate, Set<List<Integer>> set, Set<List<Integer>> cache)
    {
        int i = coordinate.get(0); 
        int j = coordinate.get(1); 
                     
        if(avoid.contains(coordinate))
        {
            return;
        }
        
        if(cache.contains(coordinate))
        {
            return;
        }
        
        avoid.add(coordinate); 
        
        set.add(coordinate); 
        cache.add(coordinate); 
        
        for(int[] dir : boundary)
        {
            int x = i + dir[0]; 
            int y = j + dir[1]; 
            
            if(!isInBounds(matrix, x, y))
            {
                continue;
            }
            
            if(matrix[x][y] < matrix[i][j])
            {
                continue; 
            }
            
            List<Integer> tmp = new LinkedList();
            tmp.add(x); 
            tmp.add(y);
            
            findRelatedNodes(matrix, tmp, set, cache); 
            
        }
        
    }
    
    public boolean isInBounds(int[][] matrix, int i, int j)
    {
        if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length)
        {
            return false;
        }
        
        return true; 
    }
    
    public void getColumns(int[][] matrix, Set<List<Integer>> pacSet, Set<List<Integer>> atlSet, Queue<List<Integer>> pacQue, Queue<List<Integer>> atlQue)
    {
        int rowPac = 0;
        int rowAtl = matrix.length-1; 
        
        for(int j = 0; j < matrix[0].length; j++)
        {
           List<Integer> pacList = new LinkedList();
           pacList.add(rowPac);
           pacList.add(j); 
            
           List<Integer> atlList = new LinkedList();
           atlList.add(rowAtl);
           atlList.add(j); 
            
           pacSet.add(pacList);
           atlSet.add(atlList); 
            
           pacQue.add(pacList); 
           atlQue.add(atlList);
          
        }
        
    }
    
    public void getRows(int[][] matrix, Set<List<Integer>> pacSet, Set<List<Integer>> atlSet, Queue<List<Integer>> pacQue, Queue<List<Integer>> atlQue)
    {
        int columnPac = 0;
        int columnAtl = matrix[0].length-1; 
        
        for(int i = 0; i < matrix.length; i++)
        {
           List<Integer> pacList = new LinkedList();
           pacList.add(i);
           pacList.add(columnPac); 
            
           List<Integer> atlList = new LinkedList();
           atlList.add(i);
           atlList.add(columnAtl); 
            
           pacSet.add(pacList);
           atlSet.add(atlList); 
            
           pacQue.add(pacList); 
           atlQue.add(atlList);
          
        }
        
    }
    
}