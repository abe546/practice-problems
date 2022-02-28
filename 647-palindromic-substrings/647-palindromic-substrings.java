class Solution {
   //Set of start and end times (index 0 is start, index 1 is end)
   private Set<List<Integer>> set = new HashSet(); 
    public int countSubstrings(String s) {
      
        if(s.length() <= 1)
        {
            return 1;
        }
        
        char[] arr = s.toCharArray();
   
        
        ArrayList<Integer> init = new ArrayList();
        init.add(0);
        init.add(0);
        
        set.add(init);
        
        for(int i = 0; i < arr.length; i++)
        {
            palindrome(i, i, arr); 
            palindrome(i, i+1, arr); 
        }
        
 
        
        return   set.size(); 
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