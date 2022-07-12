class Solution {
    public int[] dailyTemperatures(int[] T) {
      int[] answer = new int[T.length];
        
        Stack<Integer> indexes = new Stack();
        
        for(int i = 0; i < T.length; i++)
        {
            
                while(!indexes.isEmpty() && T[indexes.peek()] < T[i])
                {
                    int index = indexes.pop();
                    answer[index] = i - index;
                }
                indexes.push(i);
         
        }
 
        
        return answer; 
    }
}