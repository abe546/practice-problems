class Solution {
    public boolean divisorGame(int N) {
        
        //Alice always goes first
        boolean ranOnce = false;
        
        for(int i = 1; i <N; i++)
        {
            //System.out.println(N%i);
            if(i%2 != 0)
            {
                ranOnce = true; 
            }else
            {
                ranOnce = false; 
            }
        }
        
        return ranOnce;
    }
}
