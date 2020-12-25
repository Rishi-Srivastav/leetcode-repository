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
        
        ListNode o = null;
        ListNode p= head;
        if(p==null)
            return head;
        
        ListNode q = p.next;
        
        while(q!=null){
            if(o==null){
                p.next = q.next;
                q.next = p;
                head = q;
            } else {
                o.next = p.next;
                p.next = q.next;
                q.next = p;  
            }
              o = p; 
              p = p.next;
            if(p!=null){
              q = p.next;
            } else {
                break;
            }
        }
        return head;
    }
}