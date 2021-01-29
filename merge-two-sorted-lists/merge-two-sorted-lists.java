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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        ListNode newList = new ListNode(0); 
        
        ListNode head = newList; 
        
        ListNode current1 = l1;
        ListNode current2 = l2; 
        
        while(current1 != null && current2 != null)
        {
            if(current1.val <= current2.val)
            {
                newList.next = new ListNode(current1.val);
                current1 = current1.next; 
            }else{
                newList.next = new ListNode(current2.val); 
                current2 = current2.next; 
            }
            
            newList = newList.next; 
        }
        
        while(current1 != null)
        {
            newList.next = new ListNode(current1.val);
            current1 = current1.next; 
            newList = newList.next; 
        }
        
        while(current2 != null)
        {
            newList.next = new ListNode(current2.val);
            current2 = current2.next; 
            newList = newList.next; 
        }
        
        return head.next; 
    
    }
}