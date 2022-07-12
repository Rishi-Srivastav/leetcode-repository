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
    public int sumNumbers(TreeNode root) {
        if(root ==null) return 0;
        List<Integer> list=new ArrayList<>();
        sum(root, list, "");
        return list.stream().reduce((a,b)->a+b).get();
    }
    
    public void sum(TreeNode root, List<Integer> list, String s){
        if(root!=null)
            s=s+root.val;
        
        if(root.left==null && root.right==null){
            list.add(Integer.parseInt(s));
            return;
        }
        if(root.left!=null)
            sum(root.left, list, s);
        if(root.right!=null)
            sum(root.right, list, s);
    }
}