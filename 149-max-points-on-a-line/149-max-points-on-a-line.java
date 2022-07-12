class Solution {
    public int maxPoints(int[][] points) {
 
        
        int max = 1; 
       /**
       * Keep it simple, just count slope occurences.
       BIGGEST TAKE AWAY : Map is instantiated in first loop and is refreshed every new loop through all points. 
       */
        for(int i = 0; i < points.length; i++)
        {
            Map<Double, Integer> slopeCount = new HashMap(); 
         int y1 = points[i][0],x1 = points[i][1];
            for(int j = 0; j < points.length; j++)
            { 
                int y2 = points[j][0],x2 = points[j][1];
          
                if(j == i )
                {
                    continue;
                }
                //Set default count to 1 as we want to count ourselves as well
                //On first iteration will count ourself (point) plus next point
                if( (y2 - y1) == 0)
                {
                    slopeCount.put(0.0, slopeCount.getOrDefault(0.0, 1)+1);
           
                }else
                {
                    double slope = getSlope(x1, y1, x2, y2);
                    slopeCount.put(slope, slopeCount.getOrDefault(slope,1)+1);
                }
            }
         
          for(Map.Entry<Double, Integer> entry : slopeCount.entrySet()){
                max = Math.max(entry.getValue(), max);
            }
        }

        return max; 
    }
        
 
    
    public double getSlope(int x1, int y1, int x2, int y2)
    {
        //System.out.println(String.format("x1 = %s, y1 = %s, x2 = %s, y2 = %s", x1, y1, x2, y2)); 
        
        Double yD = new Double(y2-y1), xD =  new Double(x2-x1);
        
        return yD/xD;
    }
    
 
}