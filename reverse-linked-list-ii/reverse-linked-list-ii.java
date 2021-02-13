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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        
        if(n - m == 0)
        {
            return head;
        }
        ListNode origin = head; 
        ListNode current = head; 
        ListNode before = null; 
        int j = 0;
        while(current != null && j < (m-1))
        {
            before = current; 
            current = current.next;
            j++;
        }
        
        ListNode result = reverseList(current, j, before, n);
        
        if(result != null)
        {
            return result;
        }
 
        
        return origin; 
        
    }
    
    public ListNode reverseList(ListNode current, int j, ListNode beforeCurrent, int n)
    {
        ListNode newLink = null;
        ListNode originLink = null; 
        int i =  0; 
        while(current != null && j < n)
        {
            ListNode newNode = new ListNode(current.val); 
            newNode.next = newLink; 
            newLink = newNode; 
            
            if(i == 0)
            {
                originLink = newLink; 
            }
            
            j++;
            i++;
            current = current.next; 
        }
        
        return combineLists(current, newLink, originLink, beforeCurrent);
    }
    
    public ListNode combineLists(ListNode current, ListNode newLink, ListNode originLink, ListNode beforeCurrent)
    {
        if(beforeCurrent != null)
        {
            beforeCurrent.next = newLink;
            originLink.next = current;
        }else{
            originLink.next = current;
            
            return newLink;
        }
       
        //We return null to signify that the beforeCurrent is non null and can act as a connection, so we can use origin from before. No need to return a link, we can 
        //use the original head 
        return null; 
    }
}