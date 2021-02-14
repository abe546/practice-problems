class Solution {
    private Map<Integer, Integer> cache = new HashMap();
    public int fib(int n) {
        if(cache.get(n) != null)
        {
            return cache.get(n); 
        }
        if(n == 0)
        {
            return 0; 
        }
        
        if(n <= 2)
        {
            return 1;
        }
        
        cache.put(n, fib(n-1) + fib(n-2));
        
        return cache.get(n);
    }
}