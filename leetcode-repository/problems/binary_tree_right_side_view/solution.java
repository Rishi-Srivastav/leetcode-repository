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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root==null) return list;
        rightSide(root, list);
        return list;
    }
    
    public void rightSide(TreeNode root, List<Integer> list){
        if(root==null) return;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        queue.add(null);
        List<Integer> l = new ArrayList();
        while(!queue.isEmpty()){
            TreeNode n=queue.remove();
            if(n==null){
                list.add(l.get(l.size()-1));
                l=new ArrayList();
                if(!queue.isEmpty()){
                    queue.add(null);
                }
            } else {
                l.add(n.val);
                if(n.left!=null)
                    queue.add(n.left);
                
                if(n.right!=null)
                    queue.add(n.right);
            }
        }
    }
}