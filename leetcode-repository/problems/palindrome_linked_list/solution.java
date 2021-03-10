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
    public boolean isPalindrome(ListNode head) {
        ListNode h = reverseLL(head);
        
        while(head!=null && h!=null){
            if(head.val!=h.val){
                return false;
            }
            head=head.next;
            h=h.next;
        }
        return true;
    }
    
    public static ListNode reverseLL(ListNode head){
        ListNode headnode = null;
        while(head!=null){
            ListNode tmp = new ListNode(head.val);
            tmp.next = headnode;
            headnode = tmp;
            head=head.next;
        }
        return headnode;
    }
}