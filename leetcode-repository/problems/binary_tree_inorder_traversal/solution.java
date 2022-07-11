/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList();
        inorderTraversalIterative(root, list);
        return list;
    }
    
        public void inorderTraversalRecursive(TreeNode root, List<Integer> list) {
        if(root==null) return;
        inorderTraversalRecursive(root.left, list);
        list.add(root.val);
        inorderTraversalRecursive(root.right, list);
    }
    
    public void inorderTraversalIterative(TreeNode root, List<Integer> list) {
        if(root==null) return;
        Stack<TreeNode> stack = new Stack();
        TreeNode curr = root;
        while(!stack.isEmpty() || curr!=null){
            while(curr!=null){
                stack.push(curr);
                curr=curr.left;
            }
            curr= stack.pop();
            list.add(curr.val);
            
            curr=curr.right; 
        }
    }
}