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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode current = head; 
        
        int k = 0; 
        while(current != null)
        {
            current = current.next;
            k++;
        }
        
        k = k - n;
        
        current = head; 
 
        
        while(current != null && k >= 0)
        {
            if(k == 0)
            {
                head = current.next; 
                break; 
            }
            
            if(k == 1)
            {
                current.next = current.next.next; 
                break; 
            }
            
            current = current.next; 
            k--;
        }
        
        return head; 
        
    }
}