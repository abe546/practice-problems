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
    public ListNode reverseList(ListNode head) {
        
        ListNode current = head; 
        ListNode newList = null; 
        while(current != null)
        {
            
            ListNode next = new ListNode(current.val);
            
            next.next = newList;
            newList = next; 
            
            current = current.next; 
            
        }
        
        return newList; 
    }
}