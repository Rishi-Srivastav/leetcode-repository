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
    
    private String min;
    
    public String smallestFromLeaf(TreeNode root) {
        if(root==null) return "";
        min="~";
        smallStr(root, "");
        return min;
    }
    
    public void smallStr(TreeNode root, String s){
        if(root!=null){
            s=(char)(97+root.val)+s;
            }
        
        if(root.left==null && root.right==null && min.compareTo(s)>0 ){
            min=s;
            return;
        }
        
        if(root.left!=null)
            smallStr(root.left, s);
        if(root.right!=null)
            smallStr(root.right, s);
    }
}