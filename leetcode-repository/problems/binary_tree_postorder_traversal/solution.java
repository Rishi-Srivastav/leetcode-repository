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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList();
        postorderTraversalRecursive(root, list);
        return list;
    }
    
    public void postorderTraversalRecursive(TreeNode root, List<Integer> list){
        if(root==null) return;
        
        postorderTraversalRecursive(root.left, list);
        postorderTraversalRecursive(root.right, list);
        list.add(root.val);
    }
    
     public List<Integer> postorderTraversalIterative(TreeNode root) {
		List<Integer> out = new ArrayList<Integer>();
		if(root==null)
			return out;
		TreeNode pre=null;
		Stack<TreeNode> s = new Stack();      
		while(root!=null || !s.empty()){
			if(root!=null){				
				s.push(root);
				root = root.left;
			}
			else{
				root = s.peek();
				if(root.right==null || root.right==pre){
				    out.add(root.val);
				    s.pop();
				    pre=root;
				    root = null;
				}
				else
				    root = root.right;
			}
		}
		return out;
	}
}