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
        ListNode p=head;
        ListNode q=head;
        ListNode dummy=new ListNode(-1, head);
        ListNode pre=dummy;
        int i=1;
        while(i<n){
            q=q.next;
            i++;
        }
        while(q.next!=null){
            p=p.next;
            pre=pre.next;
            q=q.next;
        }
        pre.next=p.next;
        return dummy.next;  
    }
}