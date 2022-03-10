class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        GeoPoint origin = new GeoPoint(0,0);
        
        PriorityQueue<GeoPoint> que = new PriorityQueue<>(
            (GeoPoint a, GeoPoint b) ->
            {
               return getDistance(origin, a) - getDistance(origin, b); 
            });
        
        for(int[] arr : points)
        {
            GeoPoint newPoint = new GeoPoint(arr[0], arr[1]);
            
            que.add(newPoint);
        }
        
        int[][] answer = new int[k][2];
        
        int iter = 0;
        while(!que.isEmpty() && iter < answer.length)
        {
            GeoPoint item = que.poll(); 
            
            answer[iter][0] = item.x;
            answer[iter++][1] = item.y;
        }
        
        return answer; 
    }
    
    public int getDistance(GeoPoint original, GeoPoint compare)
    {
        int xDiffSquare = (int)Math.pow(original.x - compare.x, 2);
        int yDiffSquare = (int)Math.pow(original.y - compare.y, 2);
        
        return xDiffSquare + yDiffSquare;
    }
    
    class GeoPoint{
        int x;
        int y;
        
        public GeoPoint(int x, int y)
        {
            this.x = x; 
            this.y = y;
        }
    }
}