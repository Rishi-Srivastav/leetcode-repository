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
    public boolean isBalanced(TreeNode root) {
        AtomicBoolean bool = new AtomicBoolean(true);
        height(root, bool);
        return bool.get();
    }
    
    public static int height(TreeNode node, AtomicBoolean balanced){
        int height = 0, left = 0, right = 0 ;
        if(node == null || !balanced.get())
            return 0;
        
        left = left +1+ height(node.left, balanced);
        right = right +1+ height(node.right, balanced);
        if(Math.abs(left-right)>1){
            balanced.set(false);
        }
        return Math.max(left, right);    
    }
}