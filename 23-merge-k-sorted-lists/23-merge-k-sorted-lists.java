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
         if(lists == null || lists.length == 0)
         {
             return null; 
         }
         
        //Ask interviewer, can we modify input to speed up implementation
        ListNode newList = null;
        ListNode head = newList; 
        ListNode smallestNode = getSmallestNode(lists);
        
        while(smallestNode != null)
        { 
            if(newList == null)
            {
                newList = new ListNode();
                head = newList; 
            }
            
            newList.val = smallestNode.val;
        
            smallestNode = smallestNode.next; 
            smallestNode = getSmallestNode(lists);
            
            if(smallestNode != null)
            {
                newList.next = new ListNode();
                newList = newList.next; 
            }
        }
        
        return head; 
    }
    
    public ListNode getSmallestNode(ListNode[] lists)
    {
        ListNode item = null;
        int min = 0;
        
        for(ListNode entry : lists)
        { 
            if(entry == null)
            {
                continue; 
            }
            
            if(item == null)
            {
                item = entry;
                min = entry.val;
            }else if(min > entry.val)
            {
                item = entry;
                min = entry.val;
            }
        }
        
        for(int i = 0; i < lists.length; i++)
        { 
            ListNode entry = lists[i];
            
            if(entry == null)
            {
                continue; 
            }
            
            if(min == entry.val)
            {
                entry = entry.next; 
                lists[i] = entry; 
                break; 
            }
        }
        
        
        return item; 
    }
}