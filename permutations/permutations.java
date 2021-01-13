class Solution {
    List<List<Integer>> answer = new LinkedList(); 
    public List<List<Integer>> permute(int[] nums) {
        
        int[] numsCopy = new int[nums.length];
        
        for(int i = 0; i<nums.length; i++)
        {
            numsCopy[i] = nums[i]; 
        }
        
        permute(numsCopy, 0 );
        return answer;
    }
    
    public void permutations(int[] words, int index )
    {
        for(int i = index; i < words.length; i++)
        {
            int word1 = words[i]; 
            words[i] = words[index];
            words[index] = word1;
            
            permutations(words, i+1 );
            
            //Reset : 
            words[index] = words[i];
            words[i] = word1;
        }
        
        if(index == words.length -1)
        {
            List<Integer> list = new LinkedList(); 
            
            for(int i =0; i < words.length; i++)
            {
              list.add(words[i]);
            }
            
            answer.add(list); 
​
        }
    }
    
    public void permute(int[] nums,  int k)
    {
        for(int i=k; i<nums.length; i++)
        {
            int temp = nums[i]; 
            nums[i] = nums[k]; 
            nums[k] = temp; 
            permute(nums,  k+1);
            
            //Revert array back to original standing
            nums[k] = nums[i]; 
            nums[i] = temp; 
        }
        
        if(k == nums.length -1)
        {
            List<Integer> tmp = new LinkedList(); 
