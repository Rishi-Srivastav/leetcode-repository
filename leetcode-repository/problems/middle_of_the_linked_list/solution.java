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
    public ListNode middleNode(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode p=head;
        ListNode q=head;
        while(q.next!=null){
            p=p.next;
            if(q.next!=null && q.next.next!=null){
              q=q.next.next;   
            } else{
                break;
            }
        }
        return p;
    }
}