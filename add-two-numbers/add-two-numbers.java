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
    /**
    *Extremely important that this is a class variable. 
    * We cannot rely on current to be accurate as it is changed and brought back through
    * method param, must be class variable for that. 
    **/
    ListNode current = null;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode answer = new ListNode(0); 
        current = answer; 
        
        int carry = 0; 
        
        while(l1 != null && l2 != null)
        {
            int sum = l1.val + l2.val + carry;
            
            if(sum >= 10)
            {
                carry = 1;
            }else{
                carry = 0;
            }
            
            sum = sum % 10;
            
            current.next = new ListNode(sum);
            current = current.next;
            l1 = l1.next;
            l2 = l2.next;
        }
 
        carry = addToList(l1, carry);
         
        carry = addToList(l2, carry);   
  
        if(carry > 0)
        {
            current.next = new ListNode(carry); 
        }
   
       return answer.next; 
    }
    
    public int addToList(ListNode item, int carry)
    {
        while(item != null)
        {
             int sum = item.val + carry;
            
            if(sum >= 10)
            {
                carry = 1;
            }else{
                carry = 0;
            }
            
            sum = sum % 10;
 
            
            current.next = new ListNode(sum);
            current = current.next;
            item = item.next;
        }
 
    
        return carry;
    }
    
    public void printList(ListNode head)
    {
        System.out.println();
        while(head != null)
        {
            System.out.print(head.val + " "); 
            head = head.next; 
        }
        System.out.println();

    }
}