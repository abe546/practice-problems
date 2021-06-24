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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode answer = new ListNode(0); 
        ListNode current = answer; 
        
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
        System.out.println("CUR 0 : "+current.val); 
        System.out.println("LIST 0 : ");
        printList(answer); 
        
        ListNode item = l1; 
        
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
            
            System.out.println("SUM : "+sum); 
            
            current.next = new ListNode(sum);
            current = current.next;
            item = item.next;
        }
        System.out.println("CUR 1 : "+current.val); 
        System.out.println("LIST 1 : ");
        printList(answer); 
        
        item = l2; 
        
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
            
            System.out.println("SUM : "+sum); 
            
            current.next = new ListNode(sum);
            current = current.next;
            item = item.next;
        }
        System.out.println("CUR 2 : "+current.val); 
        System.out.println("LIST 2 : ");
        printList(answer); 
        
        if(carry > 0)
        {
            current.next = new ListNode(carry); 
        }
        System.out.println("CUR 3 : "+current.val); 
        System.out.println("LIST final : ");
        printList(answer); 
        
       return answer.next; 
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