/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> items = new HashSet(); 
        
        ListNode current = head; 
        
        while(current != null)
        {
            if(items.contains(current))
            {
                return true; 
            }
            
            items.add(current);
            current = current.next; 
        }
        
        return false; 
    }
}