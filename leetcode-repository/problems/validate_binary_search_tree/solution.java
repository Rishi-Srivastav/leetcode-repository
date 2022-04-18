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
    public boolean isValidBST(TreeNode root) {
        if(root==null)
            return true;
        TreeNode tmp=null;
        if(root.left!=null){
            tmp=root.left;
            while(tmp.right!=null){
                tmp=tmp.right;
            }
            if(tmp.val>=root.val)
                return false;
        }
        if(root.right!=null){
            tmp=root.right;
            while(tmp.left!=null){
                tmp=tmp.left;
            }
            if(tmp.val<=root.val)
                return false;
        }    
        return isValidBST(root.left) && isValidBST(root.right);
        
    }
}