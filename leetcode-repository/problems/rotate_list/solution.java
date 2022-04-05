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
   public ListNode rotateRight(ListNode head, int k) {
       if(head==null)
           return head;
       
       ListNode current = head;
       int cnt=0;
        while (current!=null){
            cnt++;
            current=current.next;
        }

        k=k%cnt;
        if(k==0)
            return head;

        int i=1;
        current = head;
        while (i<cnt-k){
            current= current.next;
            i++;
        }
        ListNode newHead = current.next;
        ListNode p = newHead;
        while (p.next!=null){
            p=p.next;
        }
        p.next=head;
        current.next=null;
        head=newHead;
        return head;
    }
}