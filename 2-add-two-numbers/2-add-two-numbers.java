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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode head = new ListNode(0); 
        
        ListNode current = head;
        int carry = 0; 
        while(l1 != null && l2 != null)
        {
            int sum = l1.val + l2.val + carry;
            
            if(sum > 9)
            {
                carry = 1;
            }else
            {
                carry = 0;
            }
            
            int value = sum % 10;
            
            current.next = new ListNode(value); 
            current = current.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        ListNode remainder = null; 
        
        remainder = l1;
        
        if(remainder == null)
        {
            remainder = l2;
        }
        
        while(remainder != null)
        {
            int sum = remainder.val + carry;
            
            if(sum > 9)
            {
                carry = 1;
            }else
            {
                carry = 0;
            }
            
            int value = sum % 10;
            
            current.next = new ListNode(value); 
            current = current.next;
            remainder = remainder.next; 
        }
        
        if(carry != 0)
        {
            current.next = new ListNode(carry); 
            current = current.next; 
        }
        
        return head.next; 
    
    }
}