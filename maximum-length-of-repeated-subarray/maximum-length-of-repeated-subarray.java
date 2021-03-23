class Solution {
    public int findLength(int[] A, int[] B) {
        
        int answer = 0; 
        
        for(int i = 0; i < A.length; i++)
        {
            int count = 0; 
            
            for(int j = 0; j < B.length; j++)
            {
                if(A[i] == B[j])
                {
                    int first = i; 
                    int second = j; 
                    
                    while(first < A.length && second < B.length && A[first] == B[second])
                    {
                        count++;
                        first++;
                        second++;
                    }
                    
                    answer = Math.max(answer, count);
                    count = 0; 
                }
            }
        }
        
        return answer; 
        
    }
}