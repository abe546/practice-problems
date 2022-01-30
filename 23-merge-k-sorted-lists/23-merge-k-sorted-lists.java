/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    private final String curr = "CURRENT"; 

    public ListNode mergeKLists(ListNode[] lists) {
       
        Map<String, ListNode> map = new HashMap(); 
          
        for(ListNode entry : lists)
        {
            ListNode current = entry; 
            
            while(current != null)
            {
             insertNode(map, current);
             current = current.next; 
            }
  
        }
        
        return map.get(curr); 
    }
    
    public ListNode insertNode(Map<String, ListNode> map, ListNode item)
    {
        ListNode current = map.get(curr); 
        ListNode currItem = new ListNode(item.val);
        
        if(current == null || currItem.val <= current.val)
        {
            currItem.next = current; 
        
            map.put(curr, currItem);
            return null;
        }
        
        
        if(current.next == null  )
        { 
            current.next = currItem;
            return null; 
        }
        
        while(current != null && current.next != null)
        {
            if(currItem.val < current.next.val)
            {
                currItem.next = current.next; 
                current.next = currItem;
                return null;
            }
            
            current = current.next;
            
            if(current.next == null)
            {
                current.next = currItem; 
                return null;
            }
        }
        
        return null; 
    }
}