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
    public ListNode removeElements(ListNode head, int val) {
        ListNode p=null;
        ListNode q=head;
        if(head==null)
            return null;
        while(q!=null){            
            if(q.val==val){
                if(p==null){
                    head=q.next;
                    q=q.next;
                    continue;
                } else{
                    p.next=q.next;
                    q=q.next;
                    continue;
                }
            }
            p=q;
          q=q.next;        
        }
        return head;
    }
}