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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 1. list2.head<list1.head=> head change
        if(list1==null) return list2;
        if(list2==null) return list1;
        ListNode head=new ListNode(-200);
        ListNode p=list1, q=list2;
        ListNode ans=head;
        while(p!=null && q!=null){
            if(p.val>q.val){
                head.next=q;
                q=q.next;
            } else {
                head.next=p;
                p=p.next;    
            }
            head=head.next;
        }
        
        head.next = p==null? q : p;

        return ans.next;
    }
}