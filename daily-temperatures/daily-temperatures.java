class Solution {
    public int[] dailyTemperatures(int[] T) {
      int[] answer = new int[T.length];
        
        Stack<Integer> indexes = new Stack();
        
        for(int i = 0; i < T.length; i++)
        {
            if(i+1 < T.length && T[i] < T[i+1] && indexes.isEmpty())
            {
                answer[i] = 1;
            }else
            {
                while(!indexes.isEmpty() && T[indexes.peek()] < T[i])
                {
                    int index = indexes.pop();
                    answer[index] = i - index;
                }
                indexes.push(i);
            }
        }
 
        
        return answer; 
    }
}
