class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
      int complexity = 0; 
      int size = jobDifficulty.length; 
      int n = size; 
      if(jobDifficulty.length < d)
      {
        return -1; 
      }    
      if(jobDifficulty.length == d)
      {
        for(int item : jobDifficulty)
        {
          complexity+=item;
        }
        return complexity; 
      }
     
      int[][] arr = new int[n+1][d+1];
      
      for(int[] entry : arr)
      {
        Arrays.fill(entry, 10000*d);
      }
      
      arr[0][0] = 0; //On day 0 takes 0 difficulty
       
      for(int i=1; i<=d; i++)
      {
        for(int j=i; n-j>=d-i;j++)
        {
          
          
          for(int k=i-1; k<j;k++)
          {
            int max=0;
            for(int m = k; m<j; m++)
            {
              max = Math.max(max, jobDifficulty[m]); 
            }
        
            arr[j][i] = Math.min(arr[j][i], arr[k][i-1]+max);
          }
        }
      }
      
      return arr[n][d]; 
}
  
 
}
