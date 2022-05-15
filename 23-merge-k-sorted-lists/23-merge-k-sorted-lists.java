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
        
       ListNode[] copy = new ListNode[lists.length];
        
        for(int i = 0; i < lists.length; i++)
        {
            copy[i] = lists[i]; 
        }
        
       ListNode currentSmallest = null;
       int smallestIndex = 0;
       ListNode answerList = new ListNode(0); 
       ListNode head = answerList; 
        
       if(lists == null || lists.length == 0)
       {
           return null; 
       } 
    
        boolean explore = false; 
        
        do{ 
        explore = false;     
        currentSmallest = null;
        smallestIndex = 0; 
            
        for(int i = 0; i < copy.length; i++)
        {
            ListNode current = copy[i]; 
                        
            if(current != null)
            {
                explore = true; 
                if(currentSmallest == null || currentSmallest.val >= current.val){
                    currentSmallest = current;
                    smallestIndex = i; 
                }
            }
        }
        
        if(explore){
        answerList.next = new ListNode(currentSmallest.val); 
        answerList = answerList.next; 
        
        copy[smallestIndex] = currentSmallest.next; 
            
        }
            
        }while (explore == true);
        
        return head.next; 
    }
}