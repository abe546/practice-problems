class Solution {
    	public static int maxPoints(int[][] points) {
        int result = 1;
        for(int i=0; i<points.length; i++){
            Map<Double, Integer> map = new HashMap<>();
            int y1 = points[i][0],x1 = points[i][1];
            for(int j=0; j<points.length; j++){
                
                if(i == j)
                {
                    continue; 
                }
                
                int y2 = points[j][0],x2 = points[j][1];
                Double yc = new Double(y1-y2),xc =  new Double(x1-x2);
                if(yc.equals(0.0)){
                    map.put(0.0, map.getOrDefault(0.0, 0)+1);
                }else if(xc.equals(0.0)) {
                    map.put(Double.NaN, map.getOrDefault(Double.NaN, 0)+1);
                }else {
                    Double key = yc/xc;
                    map.put(key, map.getOrDefault(key, 0)+1);
                }
            }
            for(Map.Entry<Double, Integer> entry : map.entrySet()){
                result = Math.max(entry.getValue()+1 , result);
            }
        }
        return result ;
    }
}