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
        
        if(p!=null && p.next!=null){
            q=p.next;
        } else {
            return false;
        }
        try{
        while(p!=null && q!=null){
            if(p == q){
                return true;
            } else {
                p=p.next;
                q= q.next.next;
            }
        }
        } catch(Exception e){
            return false;
        }
        return false;
    }
}