class Solution {
    public int minOperations(String s) {
        
        char[] arr = s.toCharArray();
        char[] zeroFirst = new char[s.length()];
        char[] oneFirst = new char[s.length()];
        
        zeroFirst[0] = '0';
        oneFirst[0] = '1';
        
        modifyArr(oneFirst);
        modifyArr(zeroFirst);
                
        int count0 = 0; 
        int count1 = 0;
        
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] != zeroFirst[i])
            {
                count0++;
            }
            
            if(arr[i] != oneFirst[i])
            {
                count1++;
            }
        }
 
        printArr(arr);
        printArr(zeroFirst); 
        printArr(oneFirst); 
        return Math.min(count0, count1); 
    }
    
    public void modifyArr(char[] arr)
    {
        for(int i = 1; i < arr.length; i++)
        {
            arr[i] = getOpposite(arr[i-1]);
        }
        
    }
    
    public void printArr(char[] arr)
    {
        System.out.println(); 
        for(int i =  0; i < arr.length; i++)
        {
            System.out.print(" "+arr[i]);
        }
        System.out.println(); 

    }
    
    public char getOpposite(char item)
    {
        if(item == '1')
        {
            return '0';
        }
        
        return '1';
    }
}