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
 
        ListNode newList = null;
        ListNode current = new ListNode(); 
        
        current = head; 
        
        while(current != null)
        {
            int value = current.val; 
            
            ListNode item = new ListNode(value);
            
            item.next = newList;
            newList = item; 
            current = current.next; 
        }
        
        return newList; 
        
    }
}