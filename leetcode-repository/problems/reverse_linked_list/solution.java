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
   public static ListNode reverseList(ListNode head) {

        return rev(head, head);
    }

    public static ListNode rev(ListNode head, ListNode headRef){
        
        ListNode first, rest;
        
        if(head == null)
            return headRef;
        
        first = head;
        rest = first.next;
        
        if(rest == null){
            headRef = first;
            return headRef;
        }

        headRef = rev(rest, headRef);
        rest.next = first;
        first.next = null;
      
        return headRef;
    }
}