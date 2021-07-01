class Solution {
    public boolean isStrobogrammatic(String num) {
        
        Map<Integer, Integer> opp = new HashMap();
        
        opp.put(0,0);
        opp.put(1, 1); 
        opp.put(6, 9);
        opp.put(8,8);
        opp.put(9,6);
        
        String flip = "";
        
        for(char entry : num.toCharArray())
        {
            if( opp.get( Integer.valueOf(""+entry)) == null)
            {
                return false; 
            }
            
            
            flip = String.format("%d", opp.getOrDefault
                                  (
                Integer.valueOf(""+entry),
                Integer.valueOf(""+entry))
                                 ) + flip;
        }
 
        return flip.equals(num); 
        
    }
}