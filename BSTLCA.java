/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BSTLCA {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (q.val < p.val) {
            TreeNode temp = p;
            p = q;
            q = temp;
        }
        if (p.val < root.val && root.val < q.val) {
            return root;
        } else if (p.val == root.val || q.val == root.val) {
            return root;
        } else {
            if (p.val < root.val && q.val < root.val) {
                return lowestCommonAncestor(root.left, p, q);
            } else if (p.val > root.val && q.val > root.val) {
                return lowestCommonAncestor(root.right, p, q);
            }
        }
        
        return null;
    }
}
