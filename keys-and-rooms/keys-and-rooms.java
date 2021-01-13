class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet();
        int size = -1;
        Stack<Integer> keys = new Stack();
        keys.push(0);
        
        while(visited.size() < rooms.size() && !keys.isEmpty())
        {
            int key = keys.pop();
            visited.add(key);
            for(int item : rooms.get(key))
            {
                if(!visited.contains(item))
                {
                    keys.push(item); 
                    visited.add(item); 
                }
            }
            
    
        }
        
        return visited.size() == rooms.size(); 
    }
}
