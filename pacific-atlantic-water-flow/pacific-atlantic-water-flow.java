class Solution {
    
    int[][] boundary = {
        {0,1},
        {1,0},
        {0,-1},
        {-1,0}
    };
  
    Set<List<Integer>> pac = new LinkedHashSet(); 
    Set<List<Integer>> atl = new LinkedHashSet(); 
    Queue<List<Integer>> pacQ = new ArrayDeque(); 
    Queue<List<Integer>> atlQ = new ArrayDeque(); 
    Set<List<Integer>> avoid = new HashSet(); 
    Set<List<Integer>> both = new HashSet(); 
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
   
        List<List<Integer>> answer = new LinkedList(); 
        
        populateColumns(heights);
        populateRows(heights); 
        
        //System.out.println(atl); 
      //   System.out.println("-");
 //  System.out.println(pac); 
        
        populateQueue(pacQ, pac);
        populateQueue(atlQ, atl);
        avoid.clear(); 
        while(!pacQ.isEmpty()){
               avoid.clear(); 
            List<Integer> entry = pacQ.poll(); 
            
            touchPac(entry.get(0), entry.get(1), heights);
        }
   
        while(!atlQ.isEmpty())
        {
                 avoid.clear(); 
            List<Integer> entry = atlQ.poll(); 
            
            touchAtl(entry.get(0), entry.get(1), heights); 
        }
        
        
        
       for(List<Integer> item : pac)
       {
           if(atl.contains(item))
           {
               answer.add(item); 
           }
       }
        
        return answer; 
    }
    
     public boolean touchAtl(int i, int j, int[][] matrix)
    {
         if(i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length){
            return false; 
        }
      
        List<Integer> origin = new LinkedList();
         origin.add(i);
         origin.add(j); 
 
        avoid.add(origin); 
        atl.add(origin); 
        
        for(int[] dir : boundary)
        {
            int x = i + dir[0];
            int y = j + dir[1]; 
            
            if(x < matrix.length &&
              y < matrix[0].length &&
              x > -1 && y > -1)
            {
                if(matrix[x][y] < matrix[i][j])
                {
                    continue; 
                }
                
                List<Integer> tmp = new LinkedList();
                
                tmp.add(x); 
                tmp.add(y); 
                
                if(!avoid.contains(tmp) && touchAtl(x, y, matrix))
                {
                 List<Integer> tmp2 = new LinkedList(); 
                
                tmp2.add(i); 
                tmp2.add(j); 
                
                if(!atl.contains(tmp2))
                {
                    atlQ.add(tmp2); 
                }
                
                atl.add(tmp2); 
                }
                
            }
            
        }
         
    
         return false; 
    }
    
    public boolean touchPac(int i, int j, int[][] matrix)
    {   
       
        
        if(i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length){
            return false; 
        }
        
        List<Integer> origin = new LinkedList();
         origin.add(i);
         origin.add(j); 
 
        
        avoid.add(origin); 
        pac.add(origin); 
        
        for(int[] dir : boundary)
        {
            int x = i + dir[0];
            int y = j + dir[1]; 
            
            if(x < matrix.length &&
              y < matrix[0].length &&
              x > -1 && y > -1)
            {
              //  System.out.println("X : "+x);
               // System.out.println("Y : "+y); 
               // System.out.println("MATRIX LENGTH : "+matrix.length);
              //  System.out.println("MATRIX[0] LENGTH : "+matrix[0].length); 
               // System.out.println("I : "+i); 
              //  System.out.println("J : "+j); 
                if(matrix[x][y] < matrix[i][j])
                {
                    continue; 
                }
                
                List<Integer> tmp = new LinkedList();
                tmp.add(x); 
                tmp.add(y); 
                
                if(!avoid.contains(tmp) && touchPac(x, y, matrix))
                {
                List<Integer> tmp2 = new LinkedList();
                tmp2.add(i); 
                tmp2.add(j); 
                
                if(!pac.contains(tmp2))
                {
                    pacQ.add(tmp2); 
                }
                
                pac.add(tmp2); 
                }
                
            }
             
        }
 
        
        return false; 
    }
    
    /**
    ** Given set of integer array, copy entry to queue
    **/
    public void populateQueue(Queue<List<Integer>> que, Set<List<Integer>> set)
    {
        for(List<Integer> item : set)
        {
            que.add(item); 
        }
    }
    
    
    public void populateRows(int[][] heights)
    {
        for(int j = 0; j < heights[0].length; j++)
        {
            List<Integer> begin = new LinkedList(); 
            List<Integer> end = new LinkedList(); 
            
            begin.add(0); 
            begin.add(j); 
            
            end.add(heights.length-1);
            end.add(j);
            
            pac.add(begin); 
            atl.add(end); 
        }
    }
    
    
    public void populateColumns(int[][] heights)
    {
        for(int i = 0; i < heights.length; i++)
        {
            List<Integer> begin = new LinkedList(); 
            List<Integer> end = new LinkedList(); 
            
            begin.add(i); 
            begin.add(0); 
            
            end.add(i); 
            end.add(heights[0].length-1);
            
            pac.add(begin); 
            atl.add(end); 
        }
    }
    
 
}