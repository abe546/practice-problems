class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
         
        Map<Integer, Integer> temps= new LinkedHashMap<>();
        int[] answers = new int[temperatures.length];
        
        for(int i = temperatures.length-1; i >=0; i--)
        {
            int current = temperatures[i];
            temps.put(current, i);
            // Define as zero by default
            answers[i] = 0;
    
            for(Integer entry : temps.keySet())
            {  
                
                if(entry.intValue() > temperatures[i])
                { 
                    if(answers[i] == 0)
                    {
                        answers[i] = temps.get(entry.intValue()) - i;
                    }
               
                    
                    answers[i] = Math.min(
                        temps.get(entry.intValue()) - i, answers[i]);
               
                }
            }
            
        }
        
        return answers; 
    }
}