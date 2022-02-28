class Solution {
 
    public String longestPalindrome(String s) {
    
    
        if(s.length() <= 1)
        {
            return s; 
        }
        
        char[] arr = s.toCharArray();
        
        int start = 0; 
        int end = 0;
        
        for(int i = 0; i < arr.length; i++)
        {
              
            int[] resultA = palindrome(i, i, arr); 
 
            int[] resultB = palindrome(i, i+1, arr); 
            
            if(end - start < resultA[1] - resultA[0])
            {
                end = resultA[1]; 
                start = resultA[0];
   
            }
            
            if(end - start < resultB[1] - resultB[0])
            {
                end = resultB[1]; 
                start = resultB[0]; 
 
            }
        }
        
        return s.substring(start, end + 1);
    }
    
    /**
    * Method to find a palindrome's start and end index
    */
    public int[] palindrome(int left, int right, char[] arr)
    {
        int[] answer = {0, 0};
        
        while(left >= 0 && right < arr.length && arr[left] == arr[right])
        {
            answer[0] = left;
            answer[1] = right;
    
            left--;
            right++;
        }

        return answer;
    }
}