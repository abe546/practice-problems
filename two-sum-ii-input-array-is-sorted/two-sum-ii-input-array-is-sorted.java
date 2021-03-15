class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        int i = 0; 
        int j = numbers.length-1; 
        int[] arr = null; 
        while (i <= j)
        {
            if(target > numbers[i]+numbers[j])
            {
                i++;
            }else if (target < numbers[i]+numbers[j])
            {
                j--;
            }else if(target == numbers[i]+numbers[j])
            {
                int[] arr2 = {i+1, j+1}; // Add one since the answer should be
                //1 indexed based, and its currently zero based
                
                return arr2;
            }
        }
        
        return null; 
    }
}