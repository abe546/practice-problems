class Solution {
 
 
    public int minDays(int n) {
 
       
        return minStepsTo1Iterative(n); 
        
    }
    
    public int minStepsDynamic(int n)
    {
         //The idea is to start at 1, and from here we will 
        //multiply by 3, 2, or add 1 and for these values, if they're
        //within the array size we will populate the array index with the 
        //current step count or we will leave what is there if its smaller and not 0
        //
        int[] steps = new int[n+1];
        
        Arrays.fill(steps, Integer.MAX_VALUE); 
        
        steps[0] = 0; 
        steps[1] = 1;
        
        for(int i = 1; i < steps.length; i++)
        {
            int step = steps[i]; 
            
            if(i * 3 < steps.length)
            {
                steps[i*3] = Math.min(step+1, steps[i*3]);
            }
            
            if(i * 2 < steps.length)
            {
                steps[i*2] = Math.min(step+1, steps[i*2]);
            }
            
            if(i+1 < steps.length)
            {
                steps[i+1] = Math.min(step+1, steps[i+1]);
            }
        }
        
        return steps[n]; 
    }
    
    public int minStepsTo1Iterative(int n)
    {
        Set<Integer> ignore = new HashSet(); 
        
        int steps = 0; //We will set steps to 0, and eventually we will find
        //the base case of n = 1 where we can then return the incremented steps
        
        Queue<Integer> nItems = new LinkedList(); 
        
        nItems.add(n);
        ignore.add(n); 
        
        while(!nItems.isEmpty())
        {
            int limit = nItems.size();
            
            for(int i = 0; i < limit; i++){
            
            int node = nItems.poll(); 
            
            if(node == 1)
            {
                return steps+1;
            }
            
            //Assumed that n will never be less than 1 at this point.
            if(!ignore.contains(node-1))
            {nItems.add(node-1);
            ignore.add(node-1);
            }
                
            if(node % 3 == 0 && !ignore.contains(node/3))
            {
                nItems.add(node/3);
                ignore.add(node/3);
            }
                
            if(node % 2 == 0 && !ignore.contains(node/2))
            {
                nItems.add(node/2);
                ignore.add(node/2); 
            }
            
           
                
            }
            
            steps++; 
        }
        
        return steps; 
    }
 
}