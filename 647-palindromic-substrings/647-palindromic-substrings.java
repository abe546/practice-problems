class Solution {
   //Set of start and end times (index 0 is start, index 1 is end)
   private Set<List<Integer>> set = new HashSet(); 
    public int countSubstrings(String s) {
      
        if(s.length() <= 1)
        {
            return 1;
        }
        
        char[] arr = s.toCharArray();
        int count = 0; 
        for(int i = 0; i < arr.length; i++)
        {
            for(int j = i+1; j <= arr.length; j++)
            {
                StringBuilder sb = new StringBuilder(); 
                String tmp = s.substring(i,j);
                sb.append(tmp);
                
                if(isPalindrome(tmp, sb))
                {
                    count++;
                }
            }
        }
        
        return count; 
    }
    /**
    * Given a String and a StringBuilder return true if they're a palindrome of each other
    */
    public boolean isPalindrome(String origin, StringBuilder compare)
    {
        return origin.equals(compare.reverse().toString()); 
    }
    
    /**
    * Find all possible palindromes from point given. Iterate left and right, until arr[left] != arr[right]
    */
    public void palindrome(int left, int right, char[] arr)
    {        
        while(left >= 0 && right < arr.length && arr[left] == arr[right])
        {
            ArrayList<Integer> tmp = new ArrayList();
            
            tmp.add(left);
            tmp.add(right);
            
            set.add(tmp);
            
            left--;
            right++;
        }
    }
}