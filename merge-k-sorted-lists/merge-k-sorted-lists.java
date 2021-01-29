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
    public ListNode mergeKLists(ListNode[] lists) {
        
        ListNode newList = new ListNode(0); 
        ListNode head = newList; //Keep a pointer to the head
        
        for(ListNode node : lists)
        {
            ListNode current = node; 
            
            while(current != null){
            System.out.println("CURRENT : "+current.val);     
            ListNode item = current; 
            insertNode(head, item);
            current = current.next;     
            }
        }
        
        return head.next; 
        
    }
    
    public void insertNode(ListNode head, ListNode node)
    {
        ListNode current = head; 
        
        while(current.next != null && current.next.val < node.val)
        {
            current = current.next; 
        }
        
        pieceTogether(current, node); 
    }
    
    public void pieceTogether(ListNode before, ListNode node)
    {
        ListNode newNext = new ListNode(node.val); 
        
        newNext.next = before.next; 
        before.next = newNext; 
        
    }
}