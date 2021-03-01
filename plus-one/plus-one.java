class Solution {
    public int[] plusOne(int[] digits) {
        
        if(digits == null || digits.length == 0)
        {
            return digits; 
        }
        
        int last = digits[digits.length-1]; 
        int increment = last; 
        if(last != 9)
        {            
            digits[digits.length-1] = increment+1;
            
            return digits; 
        }
        
        List<Integer> newArr = new ArrayList(); 
        
        int carry = 1; 
        
        for(int i = digits.length-1; i >= 0; i--)
        {
            if(digits[i] == 9 && carry > 0)
            { 
                carry = 1; 
                newArr.add(0,0);
            }else
            {
                newArr.add(0, digits[i]+carry); 
                carry = 0; 
                
            }
        }
        
        if(carry > 0)
        {
            newArr.add(0, carry); 
        }
        
        int[] arr = new int[newArr.size()]; 
        
        int j = 0; 
        
        for(int item : newArr)
        {
            arr[j++] = item;
        }
        
        return arr; 
        
    }
}