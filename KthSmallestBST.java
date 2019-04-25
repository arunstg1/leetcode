/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class KthSmallestBST {
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        int left = kthSmallest(root.left, k);
        if (left != -1) {
            return left;
        }
        count++;
        if (count == k) {
            return root.val;
        }
        int right = kthSmallest(root.right, k);
        if (right != -1) {
            return right;
        }
        return -1;
    }
}
