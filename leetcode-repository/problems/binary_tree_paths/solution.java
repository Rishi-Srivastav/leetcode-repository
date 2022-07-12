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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList();
        sum(root, list, "");
        return list;
    }
    
    public void sum(TreeNode root, List<String> list, String l){
        if(root!=null)
            l=l+"->"+root.val;
        
        if(root.left==null && root.right==null){
            list.add(l.substring(2));
            return;
        }
        if(root.left!=null)
            sum(root.left, list, l);
        if(root.right!=null)
            sum(root.right, list, l);
    }
}