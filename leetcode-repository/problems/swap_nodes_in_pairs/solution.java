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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
      ListNode dummy = new ListNode(head.val, head);
        ListNode current = dummy;
        while (current != null && current.next != null && current.next.next != null) {
            ListNode p = current.next;
            ListNode q = current.next.next;
            p.next=q.next;
            q.next=p;
            current.next=q;
            current=current.next.next;
        }
        return dummy.next;
    }
}