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
        ListNode answer = null;
        
        while(current != null)
        {
            ListNode item = new ListNode(current.val);
            
            item.next = answer; 
            answer = item; 
            
            current = current.next;
        }
        
        return answer;
    }
}