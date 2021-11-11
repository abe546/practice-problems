class Solution {
    public int getSum(int a, int b) {
        
        if(Math.abs(a) < Math.abs(b))
        {
            int tmp = a; 
            a = b; 
            b = tmp; 
        }
        
        int x = Math.abs(a); 
        int y = Math.abs(b);
        int sign = 1; 
        
        if(a < 0)
        {
            sign = -1; 
        }
        
        if(a * b >= 0)
        {
            while(y != 0){
            //positive case
            int tmpX = (x^y);    
            int tmpY = (x & y) << 1;
             
            x = tmpX;
            y = tmpY; 
            
            }
            
            
        }
        else  
        {
            //negative case
            while (y != 0){
            int tmpY = ((~x)&y) << 1;
            int tmpX = (x^y);
                
            y = tmpY;
            x = tmpX;
            }
        }
        
        return x * sign; 
    }
}