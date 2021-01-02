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
    public int maxDepth(TreeNode root) {
        int depth = 0;
        if(root==null)
            return depth;
        
        int left =0, right=0;
        
        left += 1 + maxDepth(root.left);
        right += 1+ maxDepth(root.right);
        
        return Math.max(left, right);
        
    }
}