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
    // 1 -> 2 -> 3 -> 4
    // 4 -> 3 -> 2 -> 1
    public ListNode reverseList(ListNode head) {
     ListNode current = head; 
     ListNode previous = null;
        
     while(current != null)
     {
         ListNode newItem = new ListNode(current.val); 
         
         newItem.next = previous; 
         previous = newItem; 
         
         current = current.next; 
     }
    
    return previous; 
    }
    
}