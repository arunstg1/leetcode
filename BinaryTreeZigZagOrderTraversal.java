/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BinaryTreeZigZagOrderTraversal {
    Stack<TreeNode> s1 = new Stack<>();
    Stack<TreeNode> s2 = new Stack<>();
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        
        if (root == null) {
            return new ArrayList<>();
        }
        
        s1.add(root);
        
        while (!s1.isEmpty() || !s2.isEmpty()) {
            
            List<Integer> l1 = new ArrayList<>();
            while (!s1.isEmpty()) {
                TreeNode tn = s1.pop();
                
                if (tn.left != null) {
                    s2.push(tn.left);
                }
                if (tn.right != null) {
                    s2.push(tn.right);
                }
                
                l1.add(tn.val);
            }
            if (l1.size() != 0) {
                resultList.add(l1);
            }
            
            List<Integer> l2 = new ArrayList<>();
            while (!s2.isEmpty()) {
                TreeNode tn = s2.pop();
                
                if (tn.right != null) {
                    s1.push(tn.right);
                }
                if (tn.left != null) {
                    s1.push(tn.left);
                }
                
                l2.add(tn.val);
            }
            if (l2.size() != 0) {
                resultList.add(l2);
            }
        }
        
        return resultList;
        
    }
}
