/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        
        Set<ListNode> memory = new HashSet();
        
        ListNode current = head; 
        
        while(current != null)
        {
             
            if(memory.contains(current ))
            {
                return true;
            }
            
            memory.add(current );
            
            current = current.next; 
        }
        
        return false; 
    }
}
