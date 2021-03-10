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
    public ListNode reverseList(ListNode head) {
        ListNode nodehead=null;
        while(head!=null){
            ListNode tmp = new ListNode(head.val);
            tmp.next = nodehead;
            nodehead=tmp;
            head=head.next;
        }
        return nodehead;
    }
}