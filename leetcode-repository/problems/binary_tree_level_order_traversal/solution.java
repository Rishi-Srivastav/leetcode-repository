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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists= new ArrayList<>();
        
        if(root==null) return lists;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        List<Integer> list=new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode n=queue.remove();
            if(n==null){
                lists.add(list);
                list=new ArrayList();
                if(!queue.isEmpty())
                    queue.add(null);
            } else {
                list.add(n.val);
                if(n.left!=null){
                    queue.add(n.left);
                }
                if(n.right!=null){
                    queue.add(n.right);
                }
            }
        }
        return lists;
    }
}