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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      int c = 0;
      ListNode h1=l1, h2=l2, lt1=null;  
      
      while(l1!=null && l2!=null){
         l1.val += c+l2.val;
         c = l1.val/10;
         l1.val = l1.val %10;
         l2.val = l1.val;
         lt1 = l1;
         l1=l1.next;
         l2=l2.next;
        }
        
        if(l1==null && l2==null){
            if(c!=0){
            ListNode n = new ListNode(c);
            lt1.next = n;
            n.next = null;
            }
        }
        
        else{
            if(l1!=null){
                h2=null;
                populate(l1, c);    
            } else {
                h1=null;
                populate(l2, c);
            }
        }
        
    return h1==null?h2:h1;
    }

public static void populate(ListNode l, int c){
    ListNode last = null;
    while(l!=null){
     l.val+=c;
     c = l.val/10;
     l.val = l.val%10;
     
     if(l.next==null){
         last=l;
     } 
     l=l.next;
    }
    if(c!=0){
        ListNode n = new ListNode(c);
        last.next = n;
        n.next = null;
    }
   
}
}