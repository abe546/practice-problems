class Solution {
    List<List<Integer>> answer = new LinkedList(); 
    public List<List<Integer>> permute(int[] nums) {
        
        int[] clone = new int[nums.length];
        
        for(int i = 0; i < nums.length; i++)
        {
            clone[i] = nums[i]; 
        }
        
        permutations(clone, 0); 
        
        return answer;
    }
   
    public void permutations(int[] arr, int index)
    {
        for(int i = index; i < arr.length; i++)
        {
            int tmp = arr[i]; 
            arr[i] = arr[index]; 
            arr[index] = tmp;
            
            permutations(arr, index+1);
            
            arr[index] = arr[i];            
            arr[i] = tmp; 
        }
        
        if(index == arr.length)
        {
            List<Integer> tmp = new LinkedList(); 
            
            for(int i = 0; i < arr.length; i++)
            {
                tmp.add(arr[i]); 
            }
            
            answer.add(tmp); 
        }
    }
    
    }
 