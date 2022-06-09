/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int val=0, ListNode next=null) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */
public class Solution {
    public ListNode ReverseList(ListNode head) {
        ListNode pointer = null; 
        ListNode current = head;
        
        while ( current != null )
        {
            ListNode link = new ListNode(current.val);
            
            link.next = pointer;
            pointer = link; 
            
            current = current.next; 
        }
        
        return pointer; 
    }
}