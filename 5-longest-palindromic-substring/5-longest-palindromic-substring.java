class Solution {
    public String longestPalindrome(String s) {
    
        if(s.length() <= 1)
        {
            return s;
        }
        
        char[] arr = s.toLowerCase().toCharArray();
        
        int start = 0; 
        int end = 0; 
        
        for(int i = 0; i < arr.length; i++)
        {
            int[] result = findPalindrome( i, i, arr);            
           int[] result2 = findPalindrome( i, i+1, arr);
            
            int len1 = result[1] - result[0];
            int len2 = result2[1] - result2[0];
            int ansLen = end - start ; 
            
            if(ansLen < len1)
            {
                start = result[0];
                end = result[1];
                
            }
            
            if(ansLen < len2)
            {
                 start = result2[0];
                end = result2[1];
            }
            
        
            
        }
        
        return s.substring(start, end+1); 
    }
    
    public int[] findPalindrome( int left, int right, char[] arr)
    {
         int[] answer = {0,0};
 
        
        while( left >= 0 &&  right < arr.length && arr[left] == arr[right])
        {
                 answer[0] =  left--;
                  answer[1] =  right++;
   
        }
                
        return answer;
    }
}