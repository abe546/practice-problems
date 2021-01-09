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
                //As long as we don't have any entry in the stack that is less than T[i] we cant do
                //Anything, so we push
                //The moment we find a T[i] > last index added we will be popping as long as the 
                // value of indexes.peek < T[i]
                while(!indexes.isEmpty() && T[i] > T[indexes.peek()])
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
