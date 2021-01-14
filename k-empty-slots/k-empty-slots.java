class Solution {
    public int kEmptySlots(int[] bulbs, int k) {
        
        //Will use a treemap as a stand in for a number line representation
        TreeMap<Integer, Integer> treeMap = new TreeMap(); 
        int count=1;
        int answer = -1;
        for(int bulb : bulbs)
        {
            int index = bulb-1;
            treeMap.put(index, index);
            //After turning on this bulb, does there exist a bulb in the positive or negative
            //number line that exists where its on and is k indexes away?
            
            
            
            Integer key = treeMap.ceilingKey(index+1);
            
            System.out.println("KEY : "+key);
            System.out.println("INDEX: "+index); 
            System.out.println(key != null && Math.abs(index - key) == k);
            
            if(key != null && Math.abs(index - key) == (k+1))
            {
               answer = count;
                return answer; 
            }
            
            key = treeMap.floorKey(index-1);
            
            System.out.println("KEY : "+key);
             System.out.println("INDEX: "+index); 
            System.out.println(key != null && Math.abs(index - key) == k);
            
            if(key != null && Math.abs(index - key) == (k+1))
            {
               answer = count;
                return answer;
            }
            
            count++;
        }
         
        
        return answer; 
        
    }
}
