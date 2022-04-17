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
        List<List<Integer>> lists = new ArrayList<>();
        if(root==null)
            return lists;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (true) {
            List<Integer> list = new ArrayList<>();
            List<TreeNode> child=new ArrayList<>();
            while (!q.isEmpty()) {
                TreeNode node=q.poll();
                if(node!=null)
                    list.add(node.val);
                if(node.left!=null)
                    child.add(node.left);
                if(node.right!=null)
                child.add(node.right);
            }
            lists.add(list);
            q.addAll(child);
            if(child.isEmpty()){
                return lists;
            }
        }
       }
}