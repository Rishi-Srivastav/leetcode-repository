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
    public ListNode deleteDuplicates(ListNode head) {
       
        if(head==null || head.next==null)
            return head;
       
        ListNode p=head.next;
        ListNode n=head;
       while(p!=null){
           if(n.val==p.val){
               n.next=p.next;
               p=p.next;
           } else{
               n=p;
               p=p.next;
          }
       }
        return head;
    }
}