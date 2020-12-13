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
    public ListNode detectCycle(ListNode head) {
        ListNode p = head;
        ListNode q = head;
        ListNode m = null;
        int index = 0;
        
        while(p!=null && q!=null && q.next!=null){
            p=p.next;
            q=q.next.next;
            if(p==q){
                m = p;
                break;
            }
        }
        if(m==null){
             System.out.println("no cycle");
        } else {
            p = head;
            while(p!=m){
                p=p.next;
                m=m.next;
                index++;
            }
            System.out.println("tail connects to node index "+index);
        }
        return m;
    }
}