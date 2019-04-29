/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BinaryTreeLevelOrderTraversal {
    Queue<TreeNode> q = new LinkedList<>();
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> returnList = new ArrayList<>();
        
        if (root == null) {
            return new ArrayList<>();
        }
        q.add(root);
        
        int count = 1;
        
        while (!q.isEmpty()) {
            List<Integer> l = new ArrayList<>();
            
            while (count > 0) {
                TreeNode tn = q.remove();
                if (tn.left != null) {
                    q.add(tn.left);
                }
                if (tn.right != null) {
                    q.add(tn.right);
                }
                l.add(tn.val);
                count --;
            }
            
            count = q.size();
            returnList.add(l);   
        }
        return returnList;
    }
}
