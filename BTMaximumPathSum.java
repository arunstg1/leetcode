/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BTMaximumPathSum {
    int maxSum = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        maxPathSum1(root);
        return maxSum;
    }
    
    public int maxPathSum1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int leftVal = maxPathSum1(root.left);
        int rightVal = maxPathSum1(root.right);
        
        // Checking if this sub-tree (root + left tree + right tree) is greater than the current maxSum.
        int subTreeSum = root.val + leftVal + rightVal;
        if (subTreeSum > maxSum) {
            maxSum = subTreeSum;
        }
        
        // Can't return the entire sub-tree. We can just return the root val with either left or right tree, which ever is max.
        int retValue = Math.max(leftVal, rightVal) > 0 ? root.val + Math.max(leftVal, rightVal) : root.val;
        
        if (retValue > maxSum) {
            maxSum = retValue;
        }
        return retValue;
    }
}
