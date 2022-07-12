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
    
            for(int j = i; j < temperatures.length; j++)
            {  
                 if(temperatures[j] > current)
                 {
                     answers[i] = j - i; 
                     break; 
                 }
            }
            
        }
        
        return answers; 
    }
}