/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
​
    private List<Integer> list = new ArrayList(); 
    private int increment = 0; 
    public NestedIterator(List<NestedInteger> nestedList) {
       
        loadList(list, nestedList); 
    }
​
    public void loadList(List<Integer> list, List<NestedInteger> nestedList)
    {
        for(NestedInteger item : nestedList)
       {
           if(!item.isInteger()){
            loadList(list, item.getList()); 
           }else
           {
               list.add(item.getInteger()); 
           }
       }
    }
    
    @Override
    public Integer next() {
        
        return list.get(increment++);
    }
​
    @Override
    public boolean hasNext() {
        if(increment < list.size())
        {
            return true; 
        }
        
        return false;
    }
}
​
/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
