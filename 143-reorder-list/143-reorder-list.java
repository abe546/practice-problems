/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        
        if(head == null || head.next == null)
        {
            return;
        }
        
        ListNode curr = head;
        int size = 0;
        while(curr != null)
        {
            size++;
            curr = curr.next;
        }
        curr =head;
        for(int i=0; i< size; i++)
        {
            if(i%2 == 0 && curr != null && curr.next !=null && curr.next.next !=null)
            {
                ListNode node = new ListNode();
                
                ListNode fw = curr;
                ListNode after = curr.next;
                
                while(fw.next.next != null)
                {
                    fw = fw.next;
                }
                
                node.val = fw.next.val;
                node.next = after;
                           
                fw.next = null;
                
                curr.next = node;
            }
            
            curr= curr.next;
        }
        
        
    }
}