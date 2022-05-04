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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p=head,q=head, pre=new ListNode(-1, head);
        int i=1;
        /**
        Case 1: when head is changed
        Case 2 & 3: when middle & last element is changed.
        **/
       
        while(i<n){
            q=q.next;
            i++;
        }
        
        while(q.next!=null){
            pre=p;
            p=p.next;
            q=q.next;
        }
       if(pre.next==head){
           return head.next;
       } 
       pre.next=p.next;
       return head;
}
}