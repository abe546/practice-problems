class Solution {
    public int compress(char[] chars) {
        char current = 'a'; 
        int count = 0; 
        
        char[] clone = new char[chars.length]; 
        
        StringBuilder stringBuilder = new StringBuilder();
 
        int j = 0; 
        
        for(int i = 0; i < chars.length; i++)
        {
            count = 1; 
            
            while(i < chars.length -1 && chars[i] == chars[i+1])
            {
                count+=1;
                i++;
            }
            
            j = defineCharArray(chars, chars[i], clone, j, count);
        }
       
       count = 0; 
       for(int i = 0; i < chars.length; i++)
       {
                  
           chars[i] = clone[i];
      
       }
        
        return j;
      
    }
    
    public int defineCharArray(char[] chars, char item, char[] clone, int i, int count)
    {
        if(count < 2)
        {
            clone[i] = item; 
            return i+1; 
        }else if(count < 10)
        {
            
            
            clone[i] = item;
            clone[i+1] = (char)(count+'0'); 
            return i+2;
        } 
        
        //Determined count to be greater than 9
            String number = String.valueOf(count); 
            
            clone[i] = item;
            
            int k = i+1; 
            for(int j = 0; j < number.length(); j++)
            {
                clone[k++] = number.charAt(j);
            }
            
            return k;
       
    
        
    
        
    }
}