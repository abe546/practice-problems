import java.math.BigInteger;

public class Solution {
    // you need treat n as an unsigned value
     public int reverseBits(int n) {
        
         //Add the last element of n as the first element of some new item
         //n times
         
         int mask = n; 
         int item = 0; 
         
         for(int i = 0; i < 32; i++)
         {
             int value = mask & 1; 
             mask = mask >> 1; 
             item = item << 1; 
             item ^= value; 
            
             
         }
         
         return item; 
    }
}