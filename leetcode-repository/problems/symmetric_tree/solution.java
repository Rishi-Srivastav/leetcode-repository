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
    public boolean isSymmetric(TreeNode root) {
      Queue<TreeNode> stack = new LinkedList();
        stack.add(root);
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode p=stack.poll();
            TreeNode q=stack.poll();
            if(p==null && q==null){
                continue;
            } else if(p==null || q==null){
                return false;
            } else{
                if(p.val!=q.val){
                    return false; 
                }
            }
            stack.add(p.left);
            stack.add(q.right);
            stack.add(p.right);
            stack.add(q.left);
        }
        return true;
    }
}