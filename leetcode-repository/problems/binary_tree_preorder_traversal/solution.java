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
    
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorderTraversalIterative(root, list);
        return list;
        
    }
    
    public void preorderTraversalRecursive(TreeNode root, List<Integer> list) {
        if(root==null) return;
        list.add(root.val);
        preorderTraversalRecursive(root.left, list);
        preorderTraversalRecursive(root.right, list);
    }
    
    public void preorderTraversalIterative(TreeNode root, List<Integer> list) {
        Stack<TreeNode> stack = new Stack();
         stack.add(root);  
        while(!stack.isEmpty()){
            TreeNode curr= stack.pop();
            if(curr!=null){
                list.add(curr.val);
                if(curr.right!=null)
                    stack.add(curr.right);
                if(curr.left!=null)
                    stack.add(curr.left);
            }
        }
    }
    
}