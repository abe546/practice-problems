/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode current = headA;
        
        Set<ListNode> aSet = new HashSet(); 
        
        while(current != null)
        {
            aSet.add(current); 
            
            current = current.next;
        }
        
        current = headB;
        
        while(current != null)
        {
            if(aSet.contains(current))
            {
                return current;
            }
            
            current = current.next;
        }
        
        return null; 
    }
}