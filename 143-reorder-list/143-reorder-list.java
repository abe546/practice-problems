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
    
    Set<Integer> avoid = new HashSet(); 
    public void reorderList(ListNode head) {
        
        ListNode reverse = null; 
        ListNode current = head; 
  
        int n = 0; 
        while(current != null)
        {
            ListNode item = new ListNode(current.val); 
            
            item.next = reverse;
            reverse = item;
            current = current.next;
            n++; 
        }
        
        current = head; 
        
        reshape(current, reverse);
        current = head; 
 
        
        while(current != null && n >= 0)
        {
             n--; 
            if(n == 0)
            {
                current.next = null; 
                break; 
            }
            
          
    
            current = current.next; 
        }
    }
    
    public void reshape(ListNode current, ListNode reverse)
    {
        if(reverse == null)
        {
            return; 
        }
        
 
        reshape(reverse, current.next);
        current.next = reverse;
 
             
        
    }
}