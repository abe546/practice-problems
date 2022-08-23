class Solution {
    Set<Integer> history = new HashSet<>(); 
    Map<Integer, Set<Integer>> courses = new HashMap(); 
    Set<Integer> uniqueCourses = new HashSet<>(); 
    Map<Integer, Boolean> cache = new HashMap<>(); 
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
    for(int i = 0; i < prerequisites.length; i++)
    {
        int start = prerequisites[i][0]; 
        int end = prerequisites[i][1]; 
        
        Set<Integer> tmp = courses.getOrDefault(start, new HashSet<>()); 
        
        tmp.add(end); 
        
        courses.put(start, tmp); 
        uniqueCourses.add(start); 
    }
    
    for(int course : uniqueCourses)
    {
        history.clear(); 
        if(possibleToComplete(course) != true)
        {
            return false; 
        }
    }
        
        return true; 
    }
    
    public boolean possibleToComplete(int course)
    {
        if(cache.containsKey(course))
        {
            return cache.get(course); 
        }
        
        if(history.contains(course))
        {
            cache.put(course, false); 
            return false; 
        }
        
        history.add(course); 
        
        if(courses.get(course) != null)
        {
            for(int child : courses.get(course))
            {                
                if(!possibleToComplete(child))
                {
                    cache.put(course, false);
                    return false; 
                }
            }
        }
        
        history.remove(course); 
        cache.put(course, true); 
        return true; 
    }
        
}