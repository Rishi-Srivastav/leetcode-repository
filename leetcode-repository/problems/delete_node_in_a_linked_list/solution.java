/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode p=node;
        ListNode q=node.next;
       while(q.next!=null){
           p.val=q.val;
           q=q.next;
           p=p.next;
       }
        p.val=q.val;
        p.next=null;
    }
}