import java.math.BigInteger;

public class Solution {
    // you need treat n as an unsigned value
     public int reverseBits(int n) {
        int temp=0;
         System.out.println("N : "+Integer.toBinaryString(n));
        for(int i=0;i<32;i++){
            int val=n&1;
            System.out.println("VAL : "+Integer.toBinaryString(val));
             System.out.println("TEMP 0 : "+Integer.toBinaryString(temp));
            temp=temp<<1;
            System.out.println("TEMP 1 : "+Integer.toBinaryString(temp));
            temp+=val; 
            System.out.println("TEMP 2 : "+Integer.toBinaryString(temp));
            
            n=n>>>1;
            System.out.println("N : "+Integer.toBinaryString(n));

        }
        return temp;
    }
}