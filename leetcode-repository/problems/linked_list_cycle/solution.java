/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {

        ListNode p = head;
        ListNode q = head;

        if(p==null || p.next==null){
            return false;
        }

        q=p.next.next;
        while (p!=null && q!=null){
            if(p==q)
                return true;
            else if (q.next!=null){
                p=p.next;
                q=q.next.next;
            } else
                return false;
        }
        return false;
    }
}