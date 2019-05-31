/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class LeafSimilarTrees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<TreeNode> tree1Leaves = new ArrayList<>();
        List<TreeNode> tree2Leaves = new ArrayList<>();
        
        findLeaves(root1, tree1Leaves);
        findLeaves(root2, tree2Leaves);
        
        for (int i = 0; i < tree1Leaves.size(); i++) {
            if (tree1Leaves.get(i).val != tree2Leaves.get(i).val) {
                return false;
            }
        }
        return tree1Leaves.size() == tree2Leaves.size();
    }
    
    private void findLeaves(TreeNode root, List<TreeNode> leaves) {
        if (root.left == null && root.right == null) {
            leaves.add(root);
        } else {
            if (root.left != null) {
                findLeaves(root.left, leaves);
            }
            if (root.right != null) {
                findLeaves(root.right, leaves);
            }
        }
    }
}
