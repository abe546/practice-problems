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
    public ListNode mergeKLists(ListNode[] lists) {
       
        ListNode newList = null;
        ListNode head = null; 
        
        for(ListNode entry : lists)
        {
            ListNode current = entry; 
            
            while(current != null)
            {
                if(head == null)
                {
                    head = new ListNode(current.val);
                    current = current.next; 
                    continue; 
                }
                
             insertNode(head, current);
             current = current.next; 
            }
  
        }
        
        return head; 
    }
    
    public ListNode insertNode(ListNode head, ListNode item)
    {
        ListNode current = head; 
        ListNode currItem = new ListNode(item.val);
        
        if(current == null || currItem.val <= current.val)
        {
            currItem.next = current; 
    
            ListNode tml = new ListNode(head.val);
            head.val = currItem.val;
            tml.next = current.next; 
            head.next = tml;
           
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