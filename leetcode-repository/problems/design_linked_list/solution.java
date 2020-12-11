class MyLinkedList {
  Node head;
    int length;

    class Node{
        int val;
        Node next;

        public Node(int val){
            this.val = val;
        }
    }

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        this.length = 0;
        this.head = null;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        Node p = head;
        if (index == 0) {
    //        System.out.println("value at index :"+index + " is :"+head.val);
            return head.val;
        }
        if(index>length-1 || index<0)
            return -1;

        for (int i = 0; i < index; i++) {
            p = p.next;
        }
      //  System.out.println("value at index :"+index + " is :"+p.val);
        return p.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        if(head==null){
            head=new Node(val);
            length =1;
            return;
        }
        Node newHead = new Node(val);
        newHead.next = head;
        head = newHead;
        length++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        Node p = head;
        if(p ==null){
            addAtHead(val);
            return;
        }
        while (p != null && p.next != null) {
            p = p.next;
        }
        Node newNode = new Node(val);
        p.next = newNode;
        newNode.next = null;
        length++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if(index>length){
            return;
        }

        if(index ==0){
            addAtHead(val);
            return;
        }

        Node newNode = new Node(val);

        Node p = head;

        int i = 0;
        while (i < index-1 && p != null) {
            p = p.next;
            i++;
        }
        newNode.next = p.next;
        p.next = newNode;
        length++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index<0 || index>length-1){
            return;
        }

        if(index ==0){
            head = head.next;
          //  System.out.println("deleting at index:"+index+" val: "+head.val);
            length--;
            return;
        }

        int i=1;
        Node p = head;
        Node prev = head;

       // 0,1,2,3,4,null
        while(i<=index && p.next!=null){
            prev=p;
            p=p.next;
            i++;
        }
      //  System.out.println("deleting at index:"+index+" val: "+p.val);
        if(p.next!=null) {
            prev.next = p.next;
        } else {
            prev.next=null;
        }
        length--;
    }
}


/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */