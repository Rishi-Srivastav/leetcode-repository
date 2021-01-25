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
    public ListNode mergeKLists(ListNode[] lists) {
       PriorityQueue<ListNode> pq
            = new PriorityQueue<>(
                new Comparator<ListNode>() {
                    public int compare(ListNode a, ListNode b)
                    {
                        return a.val - b.val;
                    }
                });
        
        ListNode head=null, last = null;
        
        for(int i=0;i<lists.length;i++){
            if(lists[i]!=null)
                pq.add(lists[i]);
        }
        
        while(!pq.isEmpty()){
            ListNode l = pq.remove();
            if(l.next!=null)
                pq.add(l.next);
            
            if(head==null){
                head = l;
                last = l;
            } else {
                last.next = l;
                last = l;
            }
        }
        return head;
    }
}