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
        if(head==null)
          return null;
        
        ListNode dummy = new ListNode(-101);
        dummy.next = head;
        ListNode p = dummy;
        ListNode q = p.next;
        ListNode r = q.next;
        
        while(q!=null && r!=null){
            
            if(q.val==r.val){
                while(r.next !=null && r.next.val == r.val){
                    r=r.next;
                }
                p.next = r.next;
                q=p.next;
                if(q!=null)
                    r=q.next; 
            } else {
                p=p.next;
                q=q.next;
                r=r.next; 
            }
        }      
        return dummy.next;
    }
}