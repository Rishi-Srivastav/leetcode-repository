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
    public boolean findTarget(TreeNode root, int k) {
       HashSet<Integer> set = new HashSet<>();
        return findpairutil(root,k,set);
    }
    
    public boolean findpairutil(TreeNode root, int sum, HashSet<Integer> set){
        if(root==null)
            return false;
        if(findpairutil(root.left,sum,set))
            return true;
        if(set.contains(sum-root.val)){
            return true;
        } else{
            set.add(root.val);
            return findpairutil(root.right,sum,set);
        }
    }
    
}