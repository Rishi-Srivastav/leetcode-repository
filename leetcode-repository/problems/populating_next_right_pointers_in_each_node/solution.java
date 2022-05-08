/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
      if(root==null) return root;
        if(root.left!=null)
        connectNodes(root.left, root.right);
        return root;
    }
    
    public void connectNodes(Node root1, Node root2){
        root1.next=root2;
        if(root1.left!=null){
            connectNodes(root1.left, root1.right);
            connectNodes(root2.left, root2.right);
            connectNodes(root1.right, root2.left);
        }
    }
}