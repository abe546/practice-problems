class Solution {
    public int maxScore(int[] cardPoints, int k) {
      
        
 
        return getMaxPointsDynamic(cardPoints, k);
        
    }
    
    public int getMaxPointsDynamic(int[] cardPoints, int k)
    {
        int max = 0; 
        
        int[] leftSum = new int[k+1];
        int[] rightSum = new int[k+1];
        
        //Implementation choice to avoid adding extra conditionals
        leftSum[0] = 0; 
        rightSum[0] = 0;
        
        for(int i = 0; i < k; i++)
        {
            leftSum[i+1] = leftSum[i] + cardPoints[i]; 
            rightSum[i+1] = rightSum[i] + cardPoints[(cardPoints.length - 1) - i];
        }
        
        for(int i = 0; i <= k; i++)
        {
            max = Math.max(max, leftSum[i]+rightSum[rightSum.length - 1 - i]);
        }
        
        //printArr(leftSum); 
        //printArr(rightSum); 
        
        return max; 
    }
    
    public int getMaxPointsSlidingWindow(int[] cardPoints, int k)
    {
        Deque<Integer> deque = new ArrayDeque(); 
        
        int[] extendedArr = new int[cardPoints.length + k]; 
        int j = 0; 
        for(int i = cardPoints.length; i < extendedArr.length; i++)
        {
            extendedArr[i] = cardPoints[j++];
        }
        
        for(int i = 0; i < cardPoints.length; i++)
        {
            extendedArr[i] = cardPoints[i]; 
        }
        
        int score = 0; 
        int scoreRight = 0; 
        for(int i = 0; i < k; i++)
        {
            score+= extendedArr[i]; 
            deque.addLast(extendedArr[i]); 
        }
        
        deque.clear(); 
        
        for(int i = cardPoints.length - k ; i < cardPoints.length; i++)
        {
            scoreRight+= extendedArr[i]; 
            deque.addLast(extendedArr[i]); 
        }
        
        
        int tmpScore = scoreRight; 
        for(int i = cardPoints.length; i < extendedArr.length; i++)
        { 
            tmpScore = tmpScore - deque.getFirst();
            tmpScore += extendedArr[i]; 
            deque.removeFirst(); 
            deque.addLast(extendedArr[i]); 
            
            score = Math.max(tmpScore, score); 
        }
        
        return Math.max(score, scoreRight); 
    }
    
    public void printArr(int[] arr)
    {
        System.out.println(""); 
        
        for(int i = 0; i < arr.length; i++)
        {
            System.out.print(" "+arr[i]); 
        }
        
        System.out.println(""); 
    }
}