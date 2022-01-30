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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
       
        if(list1 == null && list2 == null)
        {
            return null; 
        }
        
        ListNode newList = new ListNode(); 
        ListNode head = newList; //Point to new list to avoid loss
        
        ListNode current1 = list1;
        ListNode current2 = list2;
        
        while(current1 != null || current2 != null)
        { 
 
            if(current1 == null)
            {
                newList.val = current2.val;
                current2 = current2.next;
            }else if(current2 == null)
            {
                newList.val = current1.val;
                current1 = current1.next;
            }else if(current2.val <= current1.val)
            {
                newList.val = current2.val;
                current2 = current2.next;
            }else
            {
                newList.val = current1.val;
                current1 = current1.next;
            }
            
            if(current1 != null || current2 != null){
            newList.next = new ListNode();
            newList = newList.next; 
            }
        }
        
       return head;  
    }
}